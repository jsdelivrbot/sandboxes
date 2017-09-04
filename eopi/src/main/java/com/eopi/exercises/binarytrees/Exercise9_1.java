package com.eopi.exercises.binarytrees;

public class Exercise9_1 {

    static <T> boolean isHeightBalanced(BinaryTreeNode<T> rootNode) {
        TreeNodeStatus status = getTreeNodeStatus(rootNode);
        return status.isBalanced();
    }

    /**
     * Calculates the TreeNodeStatus (height, balance) of the binary tree with the given root node using post-order traversal.
     */
    private static <T> TreeNodeStatus getTreeNodeStatus(BinaryTreeNode<T> rootNode) {
        TreeNodeStatus leftChildStatus;
        TreeNodeStatus rightChildStatus;

        //Post-order traversal - traverse left subtree first
        if (rootNode.left != null) {
            leftChildStatus = getTreeNodeStatus(rootNode.left);
        } else {
            leftChildStatus = new TreeNodeStatus();
        }

        //Only inspect right node's children if the left side is balanced.  If left side is not balanced, we can skip
        //the check as we know the tree as a whole is not balanced.
        if (rootNode.right != null && leftChildStatus.isBalanced()) {
            rightChildStatus = getTreeNodeStatus(rootNode.right);
        } else {
            rightChildStatus = new TreeNodeStatus();
        }

        int height = Math.max(leftChildStatus.getHeight(), rightChildStatus.getHeight()) + 1;
        boolean isBalanced = leftChildStatus.isBalanced() && rightChildStatus.isBalanced() &&
                Math.abs(leftChildStatus.getHeight() - rightChildStatus.getHeight()) <= 1;

        return new TreeNodeStatus(height, isBalanced);
    }
}
