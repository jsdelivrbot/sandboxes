package com.eopi.exercises.bst;

import com.eopi.exercises.binarytrees.BinaryTreeNode;
import com.eopi.exercises.binarytrees.BinaryTreeUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise14_10Test {

    @DataProvider
    public Object[][] insertionDataProvider() {
        return new Object[][] {
                {BinaryTreeUtil.createExampleBST(), 10,
                        Arrays.asList(2, 3, 5, 7, 10, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53)},
                {BinaryTreeUtil.createExampleBST(), 11,
                        Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53)},
                {new BinaryTreeNode<>(5, "root"), 6, Arrays.asList(5, 6)},
                {null, 6, Collections.singletonList(6)}
        };
    }

    @DataProvider
    public Object[][] deletionDataProvider() {
        return new Object[][] {
                {BinaryTreeUtil.createExampleBST(), 19,
                        Arrays.asList(2, 3, 5, 7, 11, 13, 17, 23, 29, 31, 37, 41, 43, 47, 53)},
                {BinaryTreeUtil.createExampleBST(), 11,
                        Arrays.asList(2, 3, 5, 7, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53)},
                {BinaryTreeUtil.createExampleBST(), 13,
                        Arrays.asList(2, 3, 5, 7, 11, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53)},
                {BinaryTreeUtil.createExampleBST(), 37,
                        Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53)},
                {BinaryTreeUtil.createExampleBST(), 17,
                        Arrays.asList(2, 3, 5, 7, 11, 13, 19, 23, 29, 31, 37, 41, 43, 47, 53)}
        };
    }

    @Test(dataProvider = "insertionDataProvider")
    public void insert_isOk(BinaryTreeNode<Integer> root, int keyToInsert, List<Integer> expected) {
        BinarySearchTree tree = new BinarySearchTree(root);

        tree.insert(keyToInsert);

        assertTrue(Exercise14_1.isBST(tree.root));
        assertEquals(BinaryTreeUtil.inorderTraversalReturningTraversedKeys(tree.root), expected);
    }

    @Test(dataProvider = "deletionDataProvider")
    public void delete_isOk(BinaryTreeNode<Integer> root, int keyToDelete, List<Integer> expected) {
        BinarySearchTree tree = new BinarySearchTree(root);

        tree.delete(keyToDelete);

        assertTrue(Exercise14_1.isBST(tree.root));
        assertEquals(BinaryTreeUtil.inorderTraversalReturningTraversedKeys(tree.root), expected);
    }
}
