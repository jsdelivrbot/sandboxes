package com.eopi.exercises.binarytrees;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Exercise9_1Test {


    @Test
    public void isHeightBalanced_unbalancedTree_returnsFalse() {
        assertFalse(Exercise9_1.isHeightBalanced(BinaryTreeUtil.createExampleUnbalancedBinaryTree()));
    }

    @Test
    public void isHeightBalanced_balancedTree_returnsTrue() {
        assertTrue(Exercise9_1.isHeightBalanced(BinaryTreeUtil.createExampleBalancedBinaryTree()));
    }
}
