package com.eopi.exercises.searching;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Exercise11_4Test {

    @DataProvider
    public Object[][] computeIntegerSquareRootProvider() {
        return new Object[][] {
                {16, 4},
                {300, 17},
                {4, 2},
                {1, 1},
                {0, 0}
        };
    }

    @Test(dataProvider = "computeIntegerSquareRootProvider")
    public void computeIntegerSquareRoot_isOk(int k, int expected) {
        assertEquals(Exercise11_4.computeIntegerSquareRoot(k), expected);
    }
}
