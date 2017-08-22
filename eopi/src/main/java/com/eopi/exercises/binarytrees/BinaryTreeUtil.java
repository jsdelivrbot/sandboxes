package com.eopi.exercises.binarytrees;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeUtil {

    /**
     * Traverses the given binary tree using the "preorder" method - root -> left subtree -> right subtree
     */
    public static <T> List<BinaryTreeNode<T>> preorderTraversal(BinaryTreeNode<T> rootNode) {
        List<BinaryTreeNode<T>> traversedNodes = new LinkedList<>();

        traversedNodes.add(rootNode);

        if (rootNode.leftChild != null) {
            traversedNodes.addAll(preorderTraversal(rootNode.leftChild));
        }

        if (rootNode.rightChild != null) {
            traversedNodes.addAll(preorderTraversal(rootNode.rightChild));
        }

        return traversedNodes;
    }

    /**
     * Traverses the given binary tree using the "inorder" method - left subtree -> root -> right subtree
     */
    public static <T> List<BinaryTreeNode<T>> inorderTraversal(BinaryTreeNode<T> rootNode) {
        List<BinaryTreeNode<T>> traversedNodes = new LinkedList<>();

        if (rootNode.leftChild != null) {
            traversedNodes.addAll(inorderTraversal(rootNode.leftChild));
        }

        traversedNodes.add(rootNode);

        if (rootNode.rightChild != null) {
            traversedNodes.addAll(inorderTraversal(rootNode.rightChild));
        }

        return traversedNodes;
    }

    /**
     * Traverses the given binary tree using the "postorder" method - left subtree -> right subtree -> root
     */
    public static <T> List<BinaryTreeNode<T>> postorderTraversal(BinaryTreeNode<T> rootNode) {
        List<BinaryTreeNode<T>> traversedNodes = new LinkedList<>();

        if (rootNode.leftChild != null) {
            traversedNodes.addAll(postorderTraversal(rootNode.leftChild));
        }

        if (rootNode.rightChild != null) {
            traversedNodes.addAll(postorderTraversal(rootNode.rightChild));
        }

        traversedNodes.add(rootNode);

        return traversedNodes;
    }

    /**
     * Creates the binary tree in Figure 9.1 with a height of 5.
     */
    public static BinaryTreeNode<Integer> createExampleUnbalancedBinaryTree() {
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(314, "A");

        //depth 1
        rootNode.leftChild = new BinaryTreeNode<>(6, "B");
        rootNode.rightChild = new BinaryTreeNode<>(6, "I");

        //depth 2
        rootNode.leftChild.leftChild = new BinaryTreeNode<>(271, "C");
        rootNode.leftChild.rightChild = new BinaryTreeNode<>(561, "F");
        rootNode.rightChild.leftChild = new BinaryTreeNode<>(2, "J");
        rootNode.rightChild.rightChild = new BinaryTreeNode<>(271, "O");

        //depth 3
        rootNode.leftChild.leftChild.leftChild = new BinaryTreeNode<>(28, "D");
        rootNode.leftChild.leftChild.rightChild = new BinaryTreeNode<>(0, "E");
        rootNode.leftChild.rightChild.rightChild = new BinaryTreeNode<>(3, "G");
        rootNode.rightChild.leftChild.rightChild = new BinaryTreeNode<>(1, "K");
        rootNode.rightChild.rightChild.rightChild = new BinaryTreeNode<>(28, "P");

        //depth 4
        rootNode.leftChild.rightChild.rightChild.leftChild = new BinaryTreeNode<>(17, "H");
        rootNode.rightChild.leftChild.rightChild.leftChild = new BinaryTreeNode<>(401, "L");
        rootNode.rightChild.leftChild.rightChild.rightChild = new BinaryTreeNode<>(257, "N");

        //depth 5
        rootNode.rightChild.leftChild.rightChild.leftChild.rightChild = new BinaryTreeNode<>(641, "M");

        return rootNode;
    }

    /**
     * Creates the binary tree in Figure 9.2 with a height of 4.
     */
    public static BinaryTreeNode<Integer> createExampleBalancedBinaryTree() {
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(314, "A");

        //depth 1
        rootNode.leftChild = new BinaryTreeNode<>(6, "B");
        rootNode.rightChild = new BinaryTreeNode<>(6, "K");

        //depth 2
        rootNode.leftChild.leftChild = new BinaryTreeNode<>(271, "C");
        rootNode.leftChild.rightChild = new BinaryTreeNode<>(561, "H");
        rootNode.rightChild.leftChild = new BinaryTreeNode<>(2, "L");
        rootNode.rightChild.rightChild = new BinaryTreeNode<>(271, "O");

        //depth 3
        rootNode.leftChild.leftChild.leftChild = new BinaryTreeNode<>(28, "D");
        rootNode.leftChild.leftChild.rightChild = new BinaryTreeNode<>(0, "G");
        rootNode.leftChild.rightChild.leftChild = new BinaryTreeNode<>(1, "I");
        rootNode.leftChild.rightChild.rightChild = new BinaryTreeNode<>(28, "J");

        rootNode.rightChild.leftChild.leftChild = new BinaryTreeNode<>(28, "M");
        rootNode.rightChild.leftChild.rightChild = new BinaryTreeNode<>(28, "N");

        //depth 4
        rootNode.leftChild.leftChild.leftChild.leftChild = new BinaryTreeNode<>(17, "E");
        rootNode.leftChild.leftChild.leftChild.rightChild = new BinaryTreeNode<>(401, "F");

        return rootNode;
    }
}
