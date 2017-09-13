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

        if (rootNode.left != null) {
            traversedNodes.addAll(preorderTraversal(rootNode.left));
        }

        if (rootNode.right != null) {
            traversedNodes.addAll(preorderTraversal(rootNode.right));
        }

        return traversedNodes;
    }

    /**
     * Traverses the given binary tree using the "inorder" method - left subtree -> root -> right subtree
     */
    public static <T> List<BinaryTreeNode<T>> inorderTraversal(BinaryTreeNode<T> rootNode) {
        List<BinaryTreeNode<T>> traversedNodes = new LinkedList<>();

        if (rootNode.left != null) {
            traversedNodes.addAll(inorderTraversal(rootNode.left));
        }

        traversedNodes.add(rootNode);

        if (rootNode.right != null) {
            traversedNodes.addAll(inorderTraversal(rootNode.right));
        }

        return traversedNodes;
    }

    /**
     * Traverses the given binary tree using the "inorder" method - left subtree -> root -> right subtree
     */
    public static <T> List<T> inorderTraversalReturningTraversedKeys(BinaryTreeNode<T> rootNode) {
        List<T> traversedNodes = new LinkedList<>();

        if (rootNode.left != null) {
            traversedNodes.addAll(inorderTraversalReturningTraversedKeys(rootNode.left));
        }

        traversedNodes.add(rootNode.data);

        if (rootNode.right != null) {
            traversedNodes.addAll(inorderTraversalReturningTraversedKeys(rootNode.right));
        }

        return traversedNodes;
    }

    /**
     * Traverses the given binary tree using the "postorder" method - left subtree -> right subtree -> root
     */
    public static <T> List<BinaryTreeNode<T>> postorderTraversal(BinaryTreeNode<T> rootNode) {
        List<BinaryTreeNode<T>> traversedNodes = new LinkedList<>();

        if (rootNode.left != null) {
            traversedNodes.addAll(postorderTraversal(rootNode.left));
        }

        if (rootNode.right != null) {
            traversedNodes.addAll(postorderTraversal(rootNode.right));
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
        rootNode.left = new BinaryTreeNode<>(6, "B", rootNode);
        rootNode.right = new BinaryTreeNode<>(6, "I", rootNode);

        //depth 2
        rootNode.left.left = new BinaryTreeNode<>(271, "C", rootNode.left);
        rootNode.left.right = new BinaryTreeNode<>(561, "F", rootNode.left);
        rootNode.right.left = new BinaryTreeNode<>(2, "J", rootNode.right);
        rootNode.right.right = new BinaryTreeNode<>(271, "O", rootNode.right);

        //depth 3
        rootNode.left.left.left = new BinaryTreeNode<>(28, "D", rootNode.left.left);
        rootNode.left.left.right = new BinaryTreeNode<>(0, "E", rootNode.left.left);
        rootNode.left.right.right = new BinaryTreeNode<>(3, "G", rootNode.left.right);
        rootNode.right.left.right = new BinaryTreeNode<>(1, "K", rootNode.right.left);
        rootNode.right.right.right = new BinaryTreeNode<>(28, "P", rootNode.right.right);

        //depth 4
        rootNode.left.right.right.left = new BinaryTreeNode<>(17, "H",
                rootNode.left.right.right);
        rootNode.right.left.right.left = new BinaryTreeNode<>(401, "L",
                rootNode.right.left.right);
        rootNode.right.left.right.right = new BinaryTreeNode<>(257, "N",
                rootNode.right.left.right);

        //depth 5
        rootNode.right.left.right.left.right = new BinaryTreeNode<>(641, "M",
                rootNode.right.left.right.left);

        return rootNode;
    }

    /**
     * Creates the binary tree in Figure 9.2 with a height of 4.
     */
    public static BinaryTreeNode<Integer> createExampleBalancedBinaryTree() {
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(314, "A");

        //depth 1
        rootNode.left = new BinaryTreeNode<>(6, "B");
        rootNode.right = new BinaryTreeNode<>(6, "K");

        //depth 2
        rootNode.left.left = new BinaryTreeNode<>(271, "C");
        rootNode.left.right = new BinaryTreeNode<>(561, "H");
        rootNode.right.left = new BinaryTreeNode<>(2, "L");
        rootNode.right.right = new BinaryTreeNode<>(271, "O");

        //depth 3
        rootNode.left.left.left = new BinaryTreeNode<>(28, "D");
        rootNode.left.left.right = new BinaryTreeNode<>(0, "G");
        rootNode.left.right.left = new BinaryTreeNode<>(1, "I");
        rootNode.left.right.right = new BinaryTreeNode<>(28, "J");

        rootNode.right.left.left = new BinaryTreeNode<>(28, "M");
        rootNode.right.left.right = new BinaryTreeNode<>(28, "N");

        //depth 4
        rootNode.left.left.left.left = new BinaryTreeNode<>(17, "E");
        rootNode.left.left.left.right = new BinaryTreeNode<>(401, "F");

        return rootNode;
    }

    /**
     * Creates the BST in Figure 14.1
     */
    public static BinaryTreeNode<Integer> createExampleBST() {
        BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<>(19, "A");

        rootNode.left = new BinaryTreeNode<>(7, "B");
        rootNode.right = new BinaryTreeNode<>(43, "I");

        rootNode.left.left = new BinaryTreeNode<>(3, "C");
        rootNode.left.right = new BinaryTreeNode<>(11, "F");
        rootNode.right.left = new BinaryTreeNode<>(23, "J");
        rootNode.right.right = new BinaryTreeNode<>(47, "O");

        rootNode.left.left.left = new BinaryTreeNode<>(2, "D");
        rootNode.left.left.right = new BinaryTreeNode<>(5, "E");
        rootNode.left.right.right = new BinaryTreeNode<>(17, "G");
        rootNode.right.left.right = new BinaryTreeNode<>(37, "K");
        rootNode.right.right.right = new BinaryTreeNode<>(53, "P");

        rootNode.left.right.right.left = new BinaryTreeNode<>(13, "H");
        rootNode.right.left.right.left = new BinaryTreeNode<>(29, "L");
        rootNode.right.left.right.right = new BinaryTreeNode<>(41, "N");

        rootNode.right.left.right.left.right = new BinaryTreeNode<>(31, "M");

        return rootNode;
    }
}
