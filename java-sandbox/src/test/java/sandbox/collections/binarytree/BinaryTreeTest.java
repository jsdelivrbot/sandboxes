package sandbox.collections.binarytree;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BinaryTreeTest {

    @Test
    public void rebalanceTree_isOk() {
                 /* Constructed skewed binary tree is
                10
               /
              8
             /
            7
           /
          6
         /
        5   */
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(10);
        tree.root.left = new BinaryTreeNode(9);
        tree.root.left.left = new BinaryTreeNode(8);
        tree.root.left.left.left = new BinaryTreeNode(7);
        tree.root.left.left.left.left = new BinaryTreeNode(6);
        tree.root.left.left.left.left.left = new BinaryTreeNode(5);

        tree.root.left.left.left.left.left.left = new BinaryTreeNode(4);
        tree.root.left.left.left.left.left.left.left = new BinaryTreeNode(3);
        tree.root.left.left.left.left.left.left.left.left = new BinaryTreeNode(2);
        tree.root.left.left.left.left.left.left.left.left.left = new BinaryTreeNode(1);

        assertFalse(tree.isBalanced());
        assertEquals(tree.getHeight(), 10);

        tree.root = tree.rebalanceTree();

        assertTrue(tree.isBalanced());
        assertEquals(tree.getHeight(), 4);
        System.out.println("Preorder traversal of balanced BST is :");
        tree.preOrder(tree.root);
    }
}
