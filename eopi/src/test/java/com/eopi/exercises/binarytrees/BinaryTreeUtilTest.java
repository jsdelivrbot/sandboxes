package com.eopi.exercises.binarytrees;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BinaryTreeUtilTest {

    private BinaryTreeNode<Integer> exampleRootNode;

    @BeforeClass
    public void setUp() {
        exampleRootNode = BinaryTreeUtil.createExampleUnbalancedBinaryTree();
    }

    @Test
    public void preorderTraversal_exampleTree_isOk() {
        List<BinaryTreeNode<Integer>> traversedNodes = BinaryTreeUtil.preorderTraversal(exampleRootNode);

        List<String> expectedIds = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P");

        assertTraversalOrder(traversedNodes, expectedIds);
    }

    @Test
    public void inorderTraversal_exampleTree_isOk() {
        List<BinaryTreeNode<Integer>> traversedNodes = BinaryTreeUtil.inorderTraversal(exampleRootNode);

        List<String> expectedIds = Arrays.asList("D", "C", "E", "B", "F", "H", "G", "A", "J", "L", "M", "K", "N", "I", "O", "P");

        assertTraversalOrder(traversedNodes, expectedIds);
    }

    @Test
    public void postorderTraversal_exampleTree_isOk() {
        List<BinaryTreeNode<Integer>> traversedNodes = BinaryTreeUtil.postorderTraversal(exampleRootNode);

        List<String> expectedIds = Arrays.asList("D", "E", "C", "H", "G", "F", "B", "M", "L", "N", "K", "J", "P", "O", "I", "A");

        assertTraversalOrder(traversedNodes, expectedIds);
    }

    private void assertTraversalOrder(List<BinaryTreeNode<Integer>> actualNodes, List<String> expectedIds) {
        assertEquals(actualNodes.size(), expectedIds.size());

        for (int i = 0; i < actualNodes.size(); i++) {
            assertEquals(actualNodes.get(i).id, expectedIds.get(i));
        }
    }
}
