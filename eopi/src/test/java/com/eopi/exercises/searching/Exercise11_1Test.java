package com.eopi.exercises.searching;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Exercise11_1Test {

    @Test
    public void findFirstOccurrence_allEntriesEqual_returnsElementAtFirstIndex() {
        List<Integer> arrayWithSameElements = Arrays.asList(5, 5, 5, 5, 5);

        assertEquals(0, Exercise11_1.findFirstOccurrence(arrayWithSameElements, 5));
    }

    @DataProvider
    private Object[][] arrayWithRepeatedElements() {
        List<Integer> arrayWithRepeatedElements = Arrays.asList(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401);
        return new Object[][] {
                {arrayWithRepeatedElements, 108, 3},
                {arrayWithRepeatedElements, 285, 6},
                {arrayWithRepeatedElements, 2, 2},
                {arrayWithRepeatedElements, -14, 0},
                {arrayWithRepeatedElements, 401, 9}
        };
    }

    @Test(dataProvider = "arrayWithRepeatedElements")
    public void findFirstOccurrence_arrayWithRepeatedElements_isOk(List<Integer> itemsToSearch, int valueToSearch,
            int expectedIndex) {

        assertEquals(Exercise11_1.findFirstOccurrence(itemsToSearch, valueToSearch), expectedIndex);
    }
}
