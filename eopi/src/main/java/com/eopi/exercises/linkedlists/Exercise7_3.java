package com.eopi.exercises.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class Exercise7_3 {

    /**
     * My solution that is not as space efficient, but is simple and fast.
     *
     * Stores a reference to each node that has been previously visited.
     */
    static <T> ListNode<T> checkListForCycle(ListNode<T> listHead) {

        Set<ListNode<T>> previouslyTraversedNodes = new HashSet<>();
        ListNode<T> cursor = listHead;

        while (cursor != null) {
            if (previouslyTraversedNodes.contains(cursor)) {
                break;
            }
            previouslyTraversedNodes.add(cursor);
            cursor = cursor.next;
        }
        return cursor;
    }

    /**
     * The "official" book solution which uses two iterators, slow and fast.  If the two iterators "collide", that indicates
     * that a cycle has been encountered.
     */
    static <T> ListNode<T> checkListForCycle_official(ListNode<T> head) {
        ListNode<T> fast = head;
        ListNode<T> slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //There is a cycle, calculate the cycle length
                int cycleLen = 0;
                do {
                    ++cycleLen;
                    fast = fast.next;
                } while (slow != fast);

                //Find the start of the cycle
                ListNode<T> cycleLenAdvancedIter = head;
                //cycleLenAdvancedIter pointer advances cycleLen first
                while (cycleLen-- > 0) {
                    cycleLenAdvancedIter = cycleLenAdvancedIter.next;
                }

                ListNode<T> iter = head;
                //Both iterators advance in tandem
                while (iter != cycleLenAdvancedIter) {
                    iter = iter.next;
                    cycleLenAdvancedIter = cycleLenAdvancedIter.next;
                }
                //iter is the start of the cycle
                return iter;
            }
        }
        return null;
    }
}
