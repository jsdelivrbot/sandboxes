package com.eopi.exercises.sorting;

import com.eopi.exercises.linkedlists.LinkedListUtil;
import com.eopi.exercises.linkedlists.ListNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercise13_10Test {

    @DataProvider
    public Object[][] listDataProvider() {
        return new Object[][] {
                {new int[] {8, 5, 4, 3, 2, 7, 6, 9, 0, 1}, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}},
                {new int[] {55, 0, 2, 6, 4, 4, 8}, new int[] {0, 2, 4, 4, 6, 8, 55}},
                {new int[] {100, 99, 98, 97, 96, 95, 94}, new int[] {94, 95, 96, 97, 98, 99, 100}},
                {new int[] {}, new int[] {}}
        };
    }

    @Test(dataProvider = "listDataProvider")
    public void stableSortList_isOk(int[] unsortedValues, int[] expectedSortedValues) {
        ListNode<Integer> head = LinkedListUtil.createLinkedList(unsortedValues);
        ListNode<Integer> sortedList = Exercise13_10.stableSortList(head);

        LinkedListUtil.verifyListResult(sortedList, expectedSortedValues);
    }
}
