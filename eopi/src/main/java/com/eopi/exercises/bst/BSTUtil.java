package com.eopi.exercises.bst;

import com.eopi.exercises.binarytrees.BinaryTreeNode;

public class BSTUtil {

    static Integer searchBst(BinaryTreeNode<Integer> root, Integer key) {
        if (root.data.equals(key)) {
            return key;
        } else if (key < root.data) {
            if (root.left == null) {
                return null;
            }
            return searchBst(root.left, key);
        } else {
            if (root.right == null) {
                return null;
            }
            return searchBst(root.right, key);
        }
    }
}
