package com.eopi.exercises.bst;

import com.eopi.exercises.binarytrees.BinaryTreeNode;

public class BinarySearchTree {

    public BinaryTreeNode<Integer> root;

    public BinarySearchTree(BinaryTreeNode<Integer> root) {
        this.root = root;
    }

    public void insert(Integer key) {
        if (root == null) {
            root = new BinaryTreeNode<>(key, "created_root_node");
            return;
        }

        BinaryTreeNode<Integer> node = findNearestNodeWithKey(root, key);

        if (node.data.equals(key)) {
            return;
        }

        if (key < node.data && node.left == null) {
            node.left = new BinaryTreeNode<>(key, "inserted_node_" + key);
        }

        if (key > node.data && node.right == null) {
            node.right = new BinaryTreeNode<>(key, "inserted_node_" + key);
        }
    }

    public void delete(Integer key) {

        //Find the node (and its parent) matching the given key
        BinaryTreeNode<Integer> nodeToDelete = root;
        BinaryTreeNode<Integer> parent = null;

        while (nodeToDelete != null && !nodeToDelete.data.equals(key)) {
            parent = nodeToDelete;
            if (key < nodeToDelete.data) {
                nodeToDelete = nodeToDelete.left;
            }
            if (key > nodeToDelete.data) {
                nodeToDelete = nodeToDelete.right;
            }
        }

        //There is no node with the given key value, nothing to delete
        if (nodeToDelete == null) {
            return;
        }

        //Node has two children - find the successor in the right subtree, set nodeToDelete node contents to that
        //of the successor, then delete the successor.  This effectively "moves" the successor node to the location of
        //nodeToDelete, then we delete the successor node.
        //We check for the presence of a right child here because we are looking for the "successor" node, which must
        //be in the right subtree.  The successor node will have the next-highest key value relative to the key of
        //nodeToDelete.
        if (nodeToDelete.right != null) {
            BinaryTreeNode<Integer> successorNode = nodeToDelete.right;
            BinaryTreeNode<Integer> successorParent = nodeToDelete;

            while (successorNode.left != null) {
                successorParent = successorNode;
                successorNode = successorNode.left;
            }
            nodeToDelete.data = successorNode.data;
            // Move links to erase the node
            if (successorParent.left == successorNode) {
                successorParent.left = successorNode.right;
            } else {
                successorParent.right = successorNode.right;
            }
            successorNode.right = null;
        } else {
            // If the node we want to delete is the root node, and there is no right subtree, then set the root
            // to be the left child (the new root of the tree)
            if (root == nodeToDelete) {
                root = nodeToDelete.left;
                //Remove reference to the root so nodeToDelete can be garbage collected
                nodeToDelete.left = null;
            } else {
                //Set the child link of the parent node to the child of the node we want to delete, effectively "bypassing"
                //the node to be deleted.
                //First check if the child was left or right of the parent, then set the parent's new child link to bypass
                //nodeToDelete and set it to nodeToDelete's left child.
                if (parent.left == nodeToDelete) {
                    parent.left = nodeToDelete.left;
                } else {
                    parent.right = nodeToDelete.left;
                }
                //Remove reference to the node in the tree so nodeToDelete can be garbage collected
                nodeToDelete.left = null;
            }
        }
    }

    /**
     * Searches the subtree at the given root, returning the node that matches the given key, if it exists.  If it does
     * not exist, it will return the node that could represent the parent of that node, if the key were to exist in the tree.
     */
    private BinaryTreeNode<Integer> findNearestNodeWithKey(BinaryTreeNode<Integer> root, Integer key) {
        if (root.data.equals(key)) {
            return root;
        } else if (key < root.data) {
            if (root.left == null) {
                return root;
            }
            return findNearestNodeWithKey(root.left, key);
        } else {
            if (root.right == null) {
                return root;
            }
            return findNearestNodeWithKey(root.right, key);
        }
    }
}
