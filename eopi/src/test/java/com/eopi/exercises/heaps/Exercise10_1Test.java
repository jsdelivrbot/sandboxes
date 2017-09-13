package com.eopi.exercises.heaps;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Exercise10_1Test {

    @Test
    public void computeUnion_isOk() {
        List<Integer> result = Exercise10_1.computeUnion(
                Arrays.asList(Arrays.asList(3, 5, 7), Arrays.asList(0, 6), Arrays.asList(0, 6, 28)));
        assertEquals(result, Arrays.asList(0, 0, 3, 5, 6, 6, 7, 28));
    }
}
