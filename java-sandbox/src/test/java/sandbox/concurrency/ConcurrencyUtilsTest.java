package sandbox.concurrency;

import org.testng.annotations.Test;

public class ConcurrencyUtilsTest {

    @Test
    public void runnableTest() throws Exception {
        ConcurrencyUtils.runnableTest();
    }

    @Test
    public void callableTest() throws Exception {
        ConcurrencyUtils.callableTest();
    }

    @Test
    public void executorTest() throws Exception {
        ConcurrencyUtils.executorTest();
    }

    @Test
    public void synchronizedTest() {
        ConcurrencyUtils.synchronizedTest();
    }

    @Test
    public void semaphoreTest() {
        ConcurrencyUtils.semaphoreTest();
    }
}
