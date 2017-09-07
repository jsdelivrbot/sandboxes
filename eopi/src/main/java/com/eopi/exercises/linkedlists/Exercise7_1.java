package com.eopi.exercises.linkedlists;

public class Exercise7_1 {

    /**
     * Takes as input two sorted lists and merges them, returning one sorted list with all of the nodes of both input
     * lists.
     */
    public static ListNode<Integer> mergeLinkedLists(ListNode<Integer> listHead1, ListNode<Integer> listHead2) {
        ListNode<Integer> mergedListHead = new ListNode<>(0, null);
        ListNode<Integer> mergedListIter = mergedListHead;

        ListNode<Integer> listIter1 = listHead1;
        ListNode<Integer> listIter2 = listHead2;

        while (listIter1 != null && listIter2 != null) {
            if (listIter1.data >= listIter2.data) {
                mergedListIter.next = listIter2;
                listIter2 = listIter2.next;
            } else {
                mergedListIter.next = listIter1;
                listIter1 = listIter1.next;
            }
            mergedListIter = mergedListIter.next;
        }

        if (listIter1 == null) {
            mergedListIter.next = listIter2;
        } else {
            mergedListIter.next = listIter1;
        }

        return mergedListHead.next;
    }
}
