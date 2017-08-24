package com.eopi.exercises.warmup;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Warmup15 {

    /**
     * Prints the numbers 1-100 sequentially.  Odd numbers are printed on one thread and evens printed on a separate thread.
     */
    static void printSequentialNumbers() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ReentrantLock lock = new ReentrantLock();
        AtomicInteger counter = new AtomicInteger(1);

        Runnable oddNumberPrinter = () -> {
          while(counter.get() < 100) {
              try {
                  lock.lock();
                  if (counter.get() % 2 == 1) {
                      System.out.println("Odd: " + counter.getAndIncrement());
                  }
              } finally {
                  lock.unlock();
              }
          }
        };

        Runnable evenNumberPrinter = () -> {
            while(counter.get() <= 100) {
                try {
                    lock.lock();
                    if (counter.get() % 2 == 0) {
                        System.out.println("Even: " + counter.getAndIncrement());
                    }
                } finally {
                    lock.unlock();
                }
            }
        };

        executor.submit(oddNumberPrinter);
        executor.submit(evenNumberPrinter);

        stop(executor);
    }

    private static void stop(ExecutorService executor) {
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
}
