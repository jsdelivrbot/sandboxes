package com.eopi.exercises.linkedlists;

/**
 * Determine if a singly-linked list is palindromic.
 */
public class Exercise7_11 {

    static boolean isListPalindromic(ListNode<Integer> head) {

        //Find the midpoint of the list
        MidpointInfo<Integer> midpointInfo = findMidpoint(head);

        //Reverse the last half of the list
        ListNode<Integer> midpointNode =
                Exercise7_2.reverseSublist(midpointInfo.midpointNode, 0, midpointInfo.index);

        //Compare nodes of first half of list with reversed second half for equality - each node should match if palindromic
        while (midpointNode.next != null) {
            if (head.data.equals(midpointNode.data)) {
                return false;
            }
            head = head.next;
            midpointNode = midpointNode.next;
        }

        return true;
    }

    /**
     * Efficiently finds the midpoint by utilizing two iterators - one that jumps ahead by one node per iteration, the other
     * that jumps ahead two nodes per iteration.  When the faster iterator reaches the end, the slow one will be at the midpoint.
     */
    private static MidpointInfo<Integer> findMidpoint(ListNode<Integer> head) {
        ListNode<Integer> slowIterator = head;
        ListNode<Integer> fastIterator = head;

        int midpointIndex = 0;
        while (fastIterator.next != null) {
            slowIterator = slowIterator.next;
            fastIterator = fastIterator.next.next;
            midpointIndex++;
        }

        return new MidpointInfo<>(slowIterator, midpointIndex);
    }

    private static class MidpointInfo<T> {

        final ListNode<T> midpointNode;
        final int index;

        MidpointInfo(ListNode<T> midpointNode, int index) {
            this.midpointNode = midpointNode;
            this.index = index;
        }
    }
}
