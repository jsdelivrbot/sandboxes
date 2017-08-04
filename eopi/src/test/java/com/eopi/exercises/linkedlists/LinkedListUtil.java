package com.eopi.exercises.linkedlists;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class LinkedListUtil {

    static ListNode<Integer> createSequentialList() {
        return createLinkedList(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    static ListNode<Integer> createListWithCycle(int[] data, int indexOfEndOfCycle) {
        ListNode<Integer> head = createLinkedList(data);

        ListNode<Integer> cursor = head;
        ListNode<Integer> prev = cursor;
        for (int i = 0; i < indexOfEndOfCycle; i++) {
            prev = cursor;
            cursor = cursor.next;
        }

        //Create the cycle condition - end of cycle points to previous node
        cursor.next = prev;

        return head;
    }

    static ListNode<Integer> createLinkedList(int[] data) {
        ListNode<Integer> head = new ListNode<>(data[0]);

        ListNode<Integer> cursor = head;
        for (int i = 1; i < data.length; i++) {
            ListNode<Integer> nextNode = new ListNode<>(data[i]);
            cursor.next = nextNode;
            cursor = nextNode;
        }
        return head;
    }

    static void verifyListResult(ListNode<Integer> listHead, int[] expected) {
        for (int expectedValue : expected) {
            assertEquals(expectedValue, listHead.data.intValue());
            listHead = listHead.next;
        }
        assertNull(listHead);
    }

}
