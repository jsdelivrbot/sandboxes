package com.eopi.exercises.linkedlists;

import org.testng.annotations.Test;

public class Exercise7_1Test {

    @Test
    public void mergeLinkedLists_twoSequentialLists_isOk() {
        ListNode<Integer> list1 = LinkedListUtil.createLinkedList(new int[] {0, 1, 2, 3, 4});
        ListNode<Integer> list2 = LinkedListUtil.createLinkedList(new int[] {5, 6, 7, 8, 9});

        ListNode<Integer> mergedList = Exercise7_1.mergeLinkedLists(list1, list2);

        LinkedListUtil.verifyListResult(mergedList, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    @Test
    public void mergeLinkedLists_twoInterleavedLists_isOk() {
        ListNode<Integer> list1 = LinkedListUtil.createLinkedList(new int[] {1, 3, 5, 7, 9});
        ListNode<Integer> list2 = LinkedListUtil.createLinkedList(new int[] {0, 2, 4, 6, 8});

        ListNode<Integer> mergedList = Exercise7_1.mergeLinkedLists(list1, list2);

        LinkedListUtil.verifyListResult(mergedList, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }
}
