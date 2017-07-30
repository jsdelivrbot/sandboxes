package com.eopi.exercises.linkedlists;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class Exercise7_2Test {

    private static ListNode<Integer> createSequentialList() {
        ListNode<Integer> head = new ListNode<>(0);

        ListNode<Integer> cursor = head;
        for (int i = 1; i <= 9; i++) {
            ListNode<Integer> nextNode = new ListNode<>(i);
            cursor.next = nextNode;
            cursor = nextNode;
        }
        return head;
    }

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


    private void verifyListResult(ListNode<Integer> listHead, int[] expected) {
        for (int expectedValue : expected) {
            assertEquals(expectedValue, listHead.data.intValue());
            listHead = listHead.next;
        }
        assertNull(listHead);
    }
}
