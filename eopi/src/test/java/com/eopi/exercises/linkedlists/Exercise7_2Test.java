package com.eopi.exercises.linkedlists;

import org.testng.annotations.Test;

import static com.eopi.exercises.linkedlists.LinkedListUtil.createSequentialList;
import static com.eopi.exercises.linkedlists.LinkedListUtil.verifyListResult;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class Exercise7_2Test {

    @Test
    public void reverseSublist_reverseEntireList_isOk() {
        ListNode<Integer> head = createSequentialList();
        ListNode<Integer> reversedListHead = Exercise7_2.reverseSublist(head, 0, 9);

        verifyListResult(reversedListHead, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
    }

    @Test
    public void reverseSublist_reverseMiddlePortion_isOk() {
        ListNode<Integer> head = createSequentialList();
        ListNode<Integer> reversedListHead = Exercise7_2.reverseSublist(head, 4, 7);

        verifyListResult(reversedListHead, new int[]{0, 1, 2, 3, 7, 6, 5, 4, 8, 9});
    }

    @Test
    public void reverseSublist_reverseFirstHalf_isOk() {
        ListNode<Integer> head = createSequentialList();
        ListNode<Integer> reversedListHead = Exercise7_2.reverseSublist(head, 0, 4);

        verifyListResult(reversedListHead, new int[]{4, 3, 2, 1, 0, 5, 6, 7, 8, 9});
    }

    @Test
    public void reverseSublist_reverseSecondHalf_isOk() {
        ListNode<Integer> head = createSequentialList();
        ListNode<Integer> reversedListHead = Exercise7_2.reverseSublist(head, 5, 9);

        verifyListResult(reversedListHead, new int[]{0, 1, 2, 3, 4, 9, 8, 7, 6, 5});
    }
}
