package com.eopi.exercises.sorting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MergesortTest {

    @DataProvider
    public Object[][] mergesortDataProvider() {
        return new Object[][] {
                {new int[] {5, 4, 6, 7, 9, 0, 8, 3, 1, 2}, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}},
                {new int[] {0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, new int[] {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}}
        };
    }

    @Test(dataProvider = "mergesortDataProvider")
    public void mergesort_isOk(int[] unsorted, int[] expected) {
        assertEquals(Mergesort.mergesortIntArray(unsorted), expected);
    }
}
