package com.eopi.exercises.bst;

import com.eopi.exercises.binarytrees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

class Exercise14_3 {

    static List<Integer> findLargestNodes(BinaryTreeNode<Integer> root, int k) {
        List<Integer> largestNodes = new ArrayList<>();
        return findLargestNodes_internal(root, k, largestNodes);
    }

    /**
     * Perform a reverse in-order traversal to retrieve the largest nodes first, and stop traversing once we've reached
     * the kth node.
     */
    private static List<Integer> findLargestNodes_internal(BinaryTreeNode<Integer> root, int nodesToAdd,
            List<Integer> largestNodes) {

        if (root.right != null && largestNodes.size() < nodesToAdd) {
            findLargestNodes_internal(root.right, nodesToAdd, largestNodes);
        }

        if (largestNodes.size() < nodesToAdd) {
            largestNodes.add(root.data);
        }

        if (root.left != null && largestNodes.size() < nodesToAdd) {
            findLargestNodes_internal(root.left, nodesToAdd, largestNodes);
        }

        return largestNodes;
    }
}
