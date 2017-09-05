package com.eopi.exercises.searching;

import java.util.List;

public class Exercise11_1 {

    /**
     * Returns the index of the first occurrence of the given value to search for.
     */
    static int findFirstOccurrence(List<Integer> itemsToSearch, int valueToSearch) {
        return BinarySearchUtil.bsearchFirstOccurrence(valueToSearch, itemsToSearch);
    }
}
