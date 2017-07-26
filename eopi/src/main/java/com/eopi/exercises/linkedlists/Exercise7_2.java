package com.eopi.exercises.linkedlists;

/**
 * Reverse a sublist within a list without allocating additional nodes
 */
public class Exercise7_2 {

	public static <T> ListNode<T> reverseSublist(ListNode<T> list, int start, int finish) {
		ListNode<T> index = list;

		//Nothing to do if start/end indices are the same
		if (start == finish) {
			return list;
		}

		//find start of sublist
		for (int i = 0; i < start - 1; i++) {
			if (index.next == null) {
				break;
			}
			index = index.next;
		}
		ListNode<T> sublistStart = index;

		index = index.next;
		ListNode<T> prevNode = index;
		index = index.next;
		ListNode<T> nextNode;
		for (int i = start; i < finish; i++) {
			if (index.next == null) {
				break;
			}
			nextNode = index.next;

			index.next = prevNode;
			prevNode = index;
			index = nextNode;
		}

		//Set the start of the original sublist to point to the last node of the original sublist
		sublistStart.next.next = index;
		//Set the node just prior to the sublist to point to the head of the new, just-reversed sublist
		sublistStart.next = prevNode;

		return list;
	}
}
