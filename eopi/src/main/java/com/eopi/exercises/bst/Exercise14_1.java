package com.eopi.exercises.bst;

import com.eopi.exercises.binarytrees.BinaryTreeNode;
import com.eopi.exercises.binarytrees.BinaryTreeUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Exercise14_1 {

    /**
     * My solution which uses an in-order traversal.  After in-order traversal, a true BST will have the nodes traversed
     * in sorted order, so we verify that the traversed nodes are indeed sorted.  Has O(n) runtime performance.
     */
    static boolean isBST(BinaryTreeNode<Integer> root) {
        List<BinaryTreeNode<Integer>> traversedNodes = BinaryTreeUtil.inorderTraversal(root);

        BinaryTreeNode<Integer> priorNode = null;
        for (BinaryTreeNode<Integer> node : traversedNodes) {
            if (priorNode == null) {
                priorNode = node;
                continue;
            }
            if (node.data < priorNode.data) {
                return false;
            }
            priorNode = node;
        }
        return true;
    }

    /**
     * Book solution which uses BFS.  Has worst-case O(n) performance but will perform much better in the case
     * where the BST property is violated at a node located at a shallow depth, as the whole tree does not need to be
     * searched in that case.
     */
    static boolean isBST_BFS(BinaryTreeNode<Integer> root) {
        //Each entry in the queue will contain an upper and lower bound on the keys stored at the subtree rooted
        //in that node.
        Queue<QueueEntry> bfsQueue = new LinkedList<>();
        bfsQueue.add(new QueueEntry(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        QueueEntry headEntry;
        while ((headEntry = bfsQueue.poll()) != null) {
            if (headEntry.treeNode != null) {
                if (headEntry.treeNode.data < headEntry.lowerBound
                        || headEntry.treeNode.data > headEntry.upperBound) {
                    return false;
                }

                //Add the left child to the queue, setting the constraints for the child nodes as:
                // [current lower bound, current node data]
                bfsQueue.add(new QueueEntry(headEntry.treeNode.left, headEntry.lowerBound, headEntry.treeNode.data));
                //Add the right child to the queue
                bfsQueue.add(new QueueEntry(headEntry.treeNode.right, headEntry.treeNode.data, headEntry.upperBound));
                //These elements will be popped off the queue FIFO, resulting in a BFS search
            }
        }

        return true;
    }

    /**
     * Contains a BinaryTreeNode and two bounds which indicate the valid ranges for the left and right child nodes in order
     * for the subtree to have the BST property.
     */
    private static class QueueEntry {
        public BinaryTreeNode<Integer> treeNode;
        public Integer lowerBound, upperBound;

        public QueueEntry(BinaryTreeNode<Integer> treeNode, Integer lowerBound, Integer upperBound) {
            this.treeNode = treeNode;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }
}
