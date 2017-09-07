package com.eopi.exercises.sorting;

import com.eopi.exercises.linkedlists.Exercise7_1;
import com.eopi.exercises.linkedlists.ListNode;

public class Exercise13_10 {

    /**
     * An efficient, stable (i.e. the relative positions of equal elements must remain unchanged) sorting algorithm for
     * linked lists.  We use mergesort because it also does not require random access, which is more suitable for linked
     * lists.
     */
    static ListNode<Integer> stableSortList(ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        //Split the list into two sublists.
        //Trick: use two iterators to easily find the center of the list.
        ListNode<Integer> preSlow = null;
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;

        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //Divide the lists
        preSlow.next = null;

        //Recursively sort both sublists
        ListNode<Integer> sortedLeftSublist = stableSortList(head);
        ListNode<Integer> sortedRightSublist = stableSortList(slow);

        //Merge the two sublists using the merging algorithm we developed in Exercise 7.1
        return Exercise7_1.mergeLinkedLists(sortedLeftSublist, sortedRightSublist);
    }
}
