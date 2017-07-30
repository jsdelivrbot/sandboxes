package com.eopi.exercises.linkedlists;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Exercise7_11Test {

    private ListNode<Integer> createPalindromicList() {
        ListNode<Integer> tail = new ListNode<>(1, null);
        ListNode<Integer> node4 = new ListNode<>(2, tail);
        ListNode<Integer> node3 = new ListNode<>(3, node4);
        ListNode<Integer> node2 = new ListNode<>(2, node3);
        return new ListNode<>(1, node2);
    }

    private ListNode<Integer> createNonPalindromicList() {
        ListNode<Integer> tail = new ListNode<>(1, null);
        ListNode<Integer> node4 = new ListNode<>(3, tail);
        ListNode<Integer> node3 = new ListNode<>(3, node4);
        ListNode<Integer> node2 = new ListNode<>(2, node3);
        return new ListNode<>(1, node2);
    }

    @Test
    public void isListPalindromic_palindromicList_returnsTrue() {
        assertTrue(Exercise7_11.isListPalindromic(createPalindromicList()));
    }

    @Test
    public void isListPalindromic_nonPalindromicList_returnsFalse() {
        assertFalse(Exercise7_11.isListPalindromic(createNonPalindromicList()));
    }
}
