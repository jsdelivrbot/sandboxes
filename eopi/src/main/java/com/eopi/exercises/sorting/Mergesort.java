package com.eopi.exercises.sorting;

import java.util.Arrays;

public class Mergesort {

    public static int[] mergesortIntArray(int[] unsorted) {
        //High level algorithm steps:
        //Recursively split array into halves until you get to size 1
        //Recursively merge the values back up into a whole, the merge operation is where the sorting occurs

        if (unsorted.length == 1) {
            return unsorted;
        }

        int midpoint = unsorted.length / 2;
        int[] firstHalf = mergesortIntArray(Arrays.copyOfRange(unsorted, 0, midpoint));
        int[] secondHalf = mergesortIntArray(Arrays.copyOfRange(unsorted, midpoint, unsorted.length));

        return merge(firstHalf, secondHalf);
    }

    private static int[] merge(int[] firstHalf, int[] secondHalf) {
        int[] mergedResult = new int[firstHalf.length + secondHalf.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < firstHalf.length || j < secondHalf.length) {
            if (i >= firstHalf.length) {
                mergedResult[k++] = secondHalf[j++];
            } else if (j >= secondHalf.length) {
                mergedResult[k++] = firstHalf[i++];
            } else if (firstHalf[i] < secondHalf[j]) {
                mergedResult[k++] = firstHalf[i++];
            } else {
                mergedResult[k++] = secondHalf[j++];
            }
        }

        return mergedResult;
    }

    //TODO:
//    public static LinkedList<Integer> mergesortLinkedList(LinkedList<Integer> unsorted) {
//        return unsorted;
//    }

//    public static LinkedList<Integer> mergeLinkedList(LinkedList<Integer> firstHalf, LinkedList<Integer> secondHalf) {
//        return unsorted;
//    }
}
