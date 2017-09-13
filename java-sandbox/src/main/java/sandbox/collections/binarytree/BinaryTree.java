package sandbox.collections.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    BinaryTreeNode root;

    /**
     * This function traverses the skewed binary tree and stores its nodes in the given nodes list.
     */
    void storeBSTNodes(BinaryTreeNode root, List<BinaryTreeNode> nodes) {
        // Base case
        if (root == null) {
            return;
        }

        // Store nodes in inorder (which is sorted order for BST)
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    /**
     * Recursive function to construct a balanced binary tree from the ordered list of nodes.
     */
    static BinaryTreeNode buildTreeUtil(List<BinaryTreeNode> nodes, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }

        // Get the middle element and make it root
        int mid = (start + end) / 2;
        BinaryTreeNode node = nodes.get(mid);

        //Using index in inorder traversal, construct left and right subtrees
        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);

        return node;
    }

    /**
     * This method will rebalance the tree if it is skewed.
     */
    BinaryTreeNode rebalanceTree() {
        // Store nodes of given BST in sorted order
        List<BinaryTreeNode> nodes = new ArrayList<>();
        storeBSTNodes(root, nodes);

        // Constucts BST from nodes[]
        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n - 1);
    }

    /* Function to do preorder traversal of tree */
    void preOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public boolean isBalanced() {
        return checkBalance(root) != -1;
    }

    /**
     * Performs a postorder traversal to determine if the tree is balanced.  We want a postorder traversal
     * because we want to check if the height of the left and right subtrees differs by more than 1, and postorder
     * will process the left and right nodes before the root node.  O(n) time complexity, O(h) space
     * complexity.
     */
    private int checkBalance(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = checkBalance(node.left);
        if (left == -1) {
            return -1;
        }
        int right = checkBalance(node.right);
        if (right == -1) {
            return -1;
        }
        //If the height difference between the left and right subtrees is ever more than 1, the tree
        //is unbalanced by definition.
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
    }

    public int getHeight() {
        return getHeightUtil(root);
    }

    private static int getHeightUtil(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeightUtil(node.left), getHeightUtil(node.right)) + 1;
    }
}
