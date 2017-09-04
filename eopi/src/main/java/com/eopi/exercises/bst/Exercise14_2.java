package com.eopi.exercises.bst;

import com.eopi.exercises.binarytrees.BinaryTreeNode;

class Exercise14_2 {

    /**
     * Finds the key in the given BST that has the next-largest value relative to the given key.  If the given key is larger
     * than all values in the BST, this method returns Integer.MAX_VALUE.  Has O(h) time complexity, where h is the height
     * of the tree.  Has O(1) space complexity as it stores an additional variable nextLargestKey.
     */
    static Integer findNextLargestKey(BinaryTreeNode<Integer> root, Integer key) {
        return findNextLargestKeyInternal(root, key, Integer.MAX_VALUE);
    }

    private static Integer findNextLargestKeyInternal(BinaryTreeNode<Integer> root, Integer key, Integer nextLargestKey) {
        if (key >= root.data) {
            if (root.right == null) {
                return nextLargestKey;
            }
            //Tail-recursive call, will be optimized by compiler
            return findNextLargestKeyInternal(root.right, key, nextLargestKey);
        } else {
            if (root.data < nextLargestKey) {
                nextLargestKey = root.data;
            }
            if (root.left == null) {
                return nextLargestKey;
            }
            //Tail-recursive call, will be optimized by compiler
            return findNextLargestKeyInternal(root.left, key, nextLargestKey);
        }
    }
}
