package com.eopi.exercises.sorting;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class Exercise13_1Test {

    @Test
    public void computeIntersection_withSampleSet_isOk() {
        Integer[] arrayOne = new Integer[] {2, 3, 3, 5, 5, 6, 7, 7, 8, 12};
        Integer[] arrayTwo = new Integer[] {5, 5, 6, 8, 8, 9, 10, 10};

        Integer[] result = Exercise13_1.computeIntersection(arrayOne, arrayTwo);

        assertTrue(Arrays.equals(result, new Integer[] {5, 6, 8}));
    }
}
