package sandbox;

import com.google.common.base.Stopwatch;
import com.google.common.primitives.Doubles;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StreamsUnitTest {

    @Test()
    public void streamsTest() throws Exception {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.
                stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void streamPerformanceTest() throws Exception {
        int sampleSize = 50000000;
        double[] arrayToTest = new double[sampleSize];

        for (int i = 0; i < sampleSize; i++) {
            arrayToTest[i] = Math.random();
        }

        Stopwatch sw = new Stopwatch();

        sw.start();
        double result = Double.MIN_VALUE;
        for (int i = 0; i < sampleSize; i++) {
            if (arrayToTest[i] > result) {
                result = arrayToTest[i];
            }
        }
        sw.stop();
        System.out.println("Array performance: " + sw.elapsedTime(TimeUnit.NANOSECONDS) / 1000000.00 +
                " ms.  Final result: " + result);

        sw.reset();
        List<Double> list = Doubles.asList(arrayToTest);
        sw.start();
        result = Double.MIN_VALUE;
        for (int i = 0; i < sampleSize; i++) {
            if (list.get(i) > result) {
                result = list.get(i);
            }
        }
        sw.stop();
        System.out.println("List performance: " + sw.elapsedTime(TimeUnit.NANOSECONDS) / 1000000.00 +
                " ms.  Final result: " + result);

        sw.reset();
        sw.start();
        result = Arrays.stream(arrayToTest).reduce(Double.MIN_VALUE, Math::max);
        sw.stop();
        System.out.println("Array sequential stream performance: " + sw.elapsedTime(TimeUnit.NANOSECONDS) / 1000000.00 +
                " ms.  Final result: " + result);

        sw.reset();
        sw.start();
        result = Arrays.stream(arrayToTest).parallel().reduce(Double.MIN_VALUE, Math::max);
        sw.stop();
        System.out.println("Array parallel stream performance: " + sw.elapsedTime(TimeUnit.NANOSECONDS) / 1000000.00 +
                " ms.  Final result: " + result);

        sw.reset();
        sw.start();
        result = list.stream().sequential().reduce(Double.MIN_VALUE, Math::max);
        sw.stop();
        System.out.println("List sequential stream performance: " + sw.elapsedTime(TimeUnit.NANOSECONDS) / 1000000.00 +
                " ms.  Final result: " + result);

        sw.reset();
        sw.start();
        result = list.stream().parallel().reduce(Double.MIN_VALUE, Math::max);
        sw.stop();
        System.out.println("List parallel stream performance: " + sw.elapsedTime(TimeUnit.NANOSECONDS) / 1000000.00 +
                " ms.  Final result: " + result);
    }
}
