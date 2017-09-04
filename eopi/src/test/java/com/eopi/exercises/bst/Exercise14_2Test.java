package com.eopi.exercises.bst;

import com.eopi.exercises.binarytrees.BinaryTreeNode;
import com.eopi.exercises.binarytrees.BinaryTreeUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Exercise14_2Test {

    @DataProvider
    public Object[][] nextLargestKeyProvider() {
        BinaryTreeNode<Integer> bst = BinaryTreeUtil.createExampleBST();
        return new Object[][] {
                {bst, 23, 29},
                {bst, 31, 37},
                {bst, 5, 7},
                {bst, 13, 17},
                {bst, 43, 47},
                {bst, 600, Integer.MAX_VALUE}
        };
    }

    @Test(dataProvider = "nextLargestKeyProvider")
    public void findNextLargestKey_isOk(BinaryTreeNode<Integer> root, Integer key, Integer expected) {
        assertEquals(Exercise14_2.findNextLargestKey(root, key), expected);
    }

}
