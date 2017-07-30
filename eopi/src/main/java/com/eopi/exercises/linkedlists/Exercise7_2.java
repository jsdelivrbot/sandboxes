package com.eopi.exercises.linkedlists;

/**
 * Reverse a sublist within a list without allocating additional nodes
 */
public class Exercise7_2 {

    /**
     * My first try at answering the question - works with all unit tests passing but not as elegantly as book solution
     */
    static <T> ListNode<T> reverseSublist(ListNode<T> listHead, int start, int finish) {
        //Nothing to do if start/end indices are the same
        if (start == finish) {
            return listHead;
        }

        ListNode<T> nodePointingToHead = new ListNode<>(null, listHead);

        //find start of sublist
        ListNode<T> nodePointingToSublistHead = findNodePointingToSublistHead(listHead, start);

        ListNode<T> prevNode = nodePointingToSublistHead;
        ListNode<T> currentNode;
        if (nodePointingToSublistHead == null) {
            currentNode = listHead;
        } else {
            currentNode = nodePointingToSublistHead.next;
        }
        ListNode<T> nextNode = null;
        for (int i = start; i <= finish; i++) {
            if (currentNode == null) {
                break;
            }
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        //Change node pointing at beginning of sublist to point to the end of the sublist
        if (nodePointingToSublistHead == null) {
            nodePointingToHead.next.next = nextNode;
            nodePointingToHead.next = prevNode;
        } else {
            nodePointingToSublistHead.next.next = nextNode;
            nodePointingToSublistHead.next = prevNode;
        }

        return nodePointingToHead.next;
    }

    /**
     * Returns the node that "points to" the head of the sublist, meaning the node's next value points to the head of the
     * sublist.  If the sublist starts at the head of the main list, this method returns null.
     */
    private static <T> ListNode<T> findNodePointingToSublistHead(ListNode<T> listHead, int sublistStartIndex) {
        if (sublistStartIndex == 0) {
            return null;
        }
        for (int i = 0; i < sublistStartIndex - 1; i++) {
            listHead = listHead.next;
        }
        return listHead;
    }

    /**
     * The "official" optimized answer in the book
     */
    static ListNode<Integer> reverseSublist_official(ListNode<Integer> L, int start, int finish) {
        //dummyHead.next always points to the head of the entire list (the variable name they chose is slightly misleading)
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        //sublistHead.next always points to the head of the sublist.  If sublist starts at the beginning of main list, this
        //will be the same as dummyHead
        ListNode<Integer> sublistHead = dummyHead;
        int k = 0;
        while (k++ < start) {
            sublistHead = sublistHead.next;
        }

        // Reverse sublist.
        //sublistIter is the node that represents the head of the original, unreversed sublist.  At the end of the loop,
        //sublistIter will be at the tail of the reversed sublist as opposed to the head of the unreversed sublist.
        ListNode<Integer> sublistIter = sublistHead.next;
        while (start++ < finish) {
            //temp is used to change most nodes in the sublist (with the exception of sublistHead) to point to their previous
            // nodes, effectively reversing the order of the items in the sublist.
            ListNode<Integer> temp = sublistIter.next;
            //Update the head of the sublist - this will get updated each iteration, and after the
            // final iteration will represent the end of the reversed sublist and its "next" value will point to the first
            // node after the end of the reversed sublist.
            sublistIter.next = temp.next;
            //Change the pointer of the node to point to the previous node
            temp.next = sublistHead.next;
            //Update the node pointing to the head of the sublist - this will get updated each iteration,
            // and after the final iteration will point to the end of the original sublist / beginning of the reversed sublist
            sublistHead.next = temp;
        }
        return dummyHead.next;
    }
}
