package com.eopi.exercises.binarytrees;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Exercise9_4Test {

    private BinaryTreeNode<Integer> rootNode = BinaryTreeUtil.createExampleUnbalancedBinaryTree();

    @Test
    public void findLca_hasNonRootCommonAncestor_findsLca() {
        BinaryTreeNode<Integer> firstNode = rootNode.rightChild.leftChild.rightChild.rightChild;
        BinaryTreeNode<Integer> secondNode = rootNode.rightChild.leftChild.rightChild.leftChild.rightChild;
        BinaryTreeNode<Integer> expectedLcaNode = rootNode.rightChild.leftChild.rightChild;

        assertEquals(Exercise9_4.findLca(firstNode, secondNode), expectedLcaNode);
    }

    @Test
    public void findLca_hasRootCommonAncestor_findsRoot() {
        BinaryTreeNode<Integer> firstNode = rootNode.leftChild.rightChild.rightChild;
        BinaryTreeNode<Integer> secondNode = rootNode.rightChild.leftChild.rightChild;

        assertEquals(Exercise9_4.findLca(firstNode, secondNode), rootNode);
    }

    @Test
    public void findLcaEfficient_hasNonRootCommonAncestor_findsLca() {
        BinaryTreeNode<Integer> firstNode = rootNode.rightChild.leftChild.rightChild.rightChild;
        BinaryTreeNode<Integer> secondNode = rootNode.rightChild.leftChild.rightChild.leftChild.rightChild;
        BinaryTreeNode<Integer> expectedLcaNode = rootNode.rightChild.leftChild.rightChild;

        assertEquals(Exercise9_4.findLca_efficient(firstNode, secondNode), expectedLcaNode);
    }

    @Test
    public void findLcaEfficient_hasRootCommonAncestor_findsRoot() {
        BinaryTreeNode<Integer> firstNode = rootNode.leftChild.rightChild.rightChild;
        BinaryTreeNode<Integer> secondNode = rootNode.rightChild.leftChild.rightChild;

        assertEquals(Exercise9_4.findLca_efficient(firstNode, secondNode), rootNode);
    }
}
