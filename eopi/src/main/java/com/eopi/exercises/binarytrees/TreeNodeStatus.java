package com.eopi.exercises.binarytrees;

/**
 * Stores the height of a binary tree at a given node, and whether or not the tree is balanced at that node.
 * Used to pass information of up the tree via recursion when calculating the height and balance of a binary tree.
 */
public class TreeNodeStatus {

    private final int height;
    private final boolean isBalanced;

    public TreeNodeStatus() {
        this.height = 0;
        this.isBalanced = true;
    }

    public TreeNodeStatus(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }

    public int getHeight() {
        return height;
    }

    public boolean isBalanced() {
        return isBalanced;
    }
}
