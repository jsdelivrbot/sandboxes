package com.eopi.exercises.linkedlists;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class Exercise7_3Test {

    @Test
    public void checkListForCycle_listWithCycle_returnsStartOfCycle() {
        ListNode<Integer> listWithCycle = LinkedListUtil.createListWithCycle(new int[] {0, 1, 2, 3, 4}, 3);
        ListNode<Integer> expectedStartOfCycle = listWithCycle;
        for (int i = 0; i < 2; i++) {
            expectedStartOfCycle = expectedStartOfCycle.next;
        }

        ListNode<Integer> actualStartOfCycle = Exercise7_3.checkListForCycle(listWithCycle);

        assertEquals(actualStartOfCycle, expectedStartOfCycle);
    }

    @Test
    public void checkListForCycle_listWithoutCycle_returnsNull() {
        ListNode<Integer> sequentialList = LinkedListUtil.createSequentialList();

        assertNull(Exercise7_3.checkListForCycle(sequentialList));
    }
}
