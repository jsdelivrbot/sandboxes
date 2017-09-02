package com.eopi.exercises.sorting;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class Exercise13_2Test {

    @Test
    public void mergeSortedArrays_withSampleSet_isOk() {
        Integer[] firstArray = new Integer[] {5, 13, 17, null, null, null, null, null};
        Integer[] secondArray = new Integer[] {3, 7, 11, 19};
        Integer[] expected = new Integer[] {3, 5, 7, 11, 13, 17, 19, null};

        assertTrue(Arrays.equals(Exercise13_2.mergeSortedArrays(firstArray, secondArray), expected));
    }
}
