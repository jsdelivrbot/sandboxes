package com.eopi.exercises.bst;

import org.testng.annotations.Test;

import static com.eopi.exercises.binarytrees.BinaryTreeUtil.createExampleBST;
import static com.eopi.exercises.binarytrees.BinaryTreeUtil.createExampleUnbalancedBinaryTree;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Exercise14_1Test {

    @Test
    public void isBST_givenBST_returnsTrue() {
        assertTrue(Exercise14_1.isBST(createExampleBST()));
    }

    @Test
    public void isBST_givenUnsortedTree_returnsFalse() {
        assertFalse(Exercise14_1.isBST(createExampleUnbalancedBinaryTree()));
    }

    @Test
    public void isBST_BFS_givenBST_returnsTrue() {
        assertTrue(Exercise14_1.isBST_BFS(createExampleBST()));
    }

    @Test
    public void isBST_BFS_givenUnsortedTree_returnsFalse() {
        assertFalse(Exercise14_1.isBST_BFS(createExampleUnbalancedBinaryTree()));
    }
}
