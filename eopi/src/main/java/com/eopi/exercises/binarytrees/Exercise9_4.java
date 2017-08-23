package com.eopi.exercises.binarytrees;

import java.util.HashSet;
import java.util.Set;

public class Exercise9_4 {

    /**
     * Finds the lowest common ancestor for both nodes.  Returns the root node if it is the only common ancestor.
     *
     * Time and space complexity is O(h), where h is the height of the table.  This is considered the "brute-force"
     * algorithm as we need to store the traversed nodes in a hash set.  A more efficient version is below.
     */
    public static <T> BinaryTreeNode<T> findLca(
            BinaryTreeNode<T> firstNode,
            BinaryTreeNode<T> secondNode) {

        Set<BinaryTreeNode<T>> traversedParentNodes = new HashSet<>();

        if (firstNode == secondNode) {
            return firstNode;
        }

        traversedParentNodes.add(firstNode);
        traversedParentNodes.add(secondNode);

        while (firstNode.parent != null) {
            if (traversedParentNodes.contains(firstNode.parent)) {
                return firstNode.parent;
            }
            traversedParentNodes.add(firstNode.parent);
            firstNode = firstNode.parent;
        }

        while (secondNode.parent != null) {
            if (traversedParentNodes.contains(secondNode.parent)) {
                return secondNode.parent;
            }
            traversedParentNodes.add(secondNode.parent);
            secondNode = secondNode.parent;
        }

        //We've hit the top of the tree without finding a lower ancestor - return the root
        return firstNode;
    }

    /**
     * Finds the lca without needing to store the nodes in the path up to the root node.
     *
     * If the two nodes start at different depths, we first follow the deeper node up the tree via the parent
     * references until it is at the same depth as the other node.
     *
     * If the nodes are at the same depths, we follow both nodes up the tree via their parent references until the two
     * nodes are equivalent, in which case we have found the LCA.
     */
    public static <T> BinaryTreeNode<T> findLca_efficient(
            BinaryTreeNode<T> firstNode,
            BinaryTreeNode<T> secondNode) {

        int firstNodeDepth = getDepth(firstNode);
        int secondNodeDepth = getDepth(secondNode);

        //If applicable, switches the node references so that "firstNode" is the deeper one, to
        //simplify the code afterwards
        if (secondNodeDepth > firstNodeDepth) {
            BinaryTreeNode<T> temp = firstNode;
            firstNode = secondNode;
            secondNode = temp;
        }

        int depthDelta = Math.abs(firstNodeDepth - secondNodeDepth);

        while (depthDelta > 0) {
            firstNode = firstNode.parent;
            depthDelta--;
        }

        while (firstNode != secondNode) {
            firstNode = firstNode.parent;
            secondNode = secondNode.parent;
        }
        return firstNode;
    }

    private static <T> int getDepth(BinaryTreeNode<T> node) {
        int depth = 0;
        while (node.parent != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }
}
