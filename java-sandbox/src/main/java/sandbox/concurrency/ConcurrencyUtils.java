package sandbox.concurrency;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ConcurrencyUtils {

    public static void runnableTest() {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello thread: " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }

    public static void callableTest() throws Exception {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException ex) {
                throw new IllegalStateException("task interrupted", ex);
            }
        };

        int test = task.call();
        System.out.println("CallableTest Done! Value: " + test);
    }

    public static void executorTest() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future test = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                String threadName = Thread.currentThread().getName();
                System.out.println("Executor test - Hello thread: " + threadName);
            } catch (InterruptedException ex) {
                throw new IllegalStateException("task interrupted", ex);
            }
        });

        test.get(1, TimeUnit.SECONDS);
    }

    private static int count = 0;
    public static void synchronizedTest() {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(ConcurrencyUtils::incrementSync));

        stop(executor);

        System.out.println(count);
    }

    private static void increment() {
        sleep(1);
        count = count + 1;
    }

    private static final Object lock = new Object();
    private static void incrementSync() {
        synchronized (lock) {
            count = count + 1;
        }
    }

    static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * This method shows an example of how semaphores work.  The semaphore is set to have 5 permits, but we
     * invoke 10 long-running threads that all use the semaphore as a lock.  The net result of this is that
     * the first 5 threads will gain a permit and will execute their code, while the next 5 will be unable to
     * obtain a permit and will not run their code.
     */
    public static void semaphoreTest() {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Semaphore semaphore = new Semaphore(5);

        Runnable longRunningTask = () -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit) {
                    System.out.println("semaphore acquired");
                    sleep(5);
                } else {
                    System.out.println("Could not acquire semaphore");
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                //It is important to release the permit even if an exception was thrown
                if (permit) {
                    semaphore.release();
                }
            }
        };

        IntStream.range(0, 10)
                .forEach(i -> executor.submit(longRunningTask));

        stop(executor);
    }
}
