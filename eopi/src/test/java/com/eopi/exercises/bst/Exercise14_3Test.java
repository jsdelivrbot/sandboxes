package com.eopi.exercises.bst;

import com.eopi.exercises.binarytrees.BinaryTreeUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Exercise14_3Test {

    @DataProvider
    public Object[][] findLargestProvider() {
        return new Object[][] {
                {5, Arrays.asList(53, 47, 43, 41, 37)},
                {12, Arrays.asList(53, 47, 43, 41, 37, 31, 29, 23, 19, 17, 13, 11)}
        };
    }

    @Test(dataProvider = "findLargestProvider")
    public void findLargestNodes_isOk(int k, List<Integer> expected) {
        List<Integer> largestFiveIntegers = Exercise14_3.findLargestNodes(BinaryTreeUtil.createExampleBST(), k);

        assertEquals(largestFiveIntegers, expected);
    }
}
