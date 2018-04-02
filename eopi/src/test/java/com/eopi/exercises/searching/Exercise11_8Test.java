package com.eopi.exercises.searching;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Exercise11_8Test {

    @DataProvider
    private Object[][] testProvider() {
        List<Integer> sourceArray = Lists.newArrayList(3, 2, 1, 5, 4);
        return new Object[][] {
                {sourceArray, 1, 5}
        };
    }

    @Test(dataProvider = "testProvider")
    public void findKthLargestElement_isOk(List<Integer> A, int k, int expected) {
        assertEquals(Exercise11_8.findKthLargestElement(A, k), expected);
    }
}
