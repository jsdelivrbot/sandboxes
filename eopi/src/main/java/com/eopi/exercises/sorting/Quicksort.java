package com.eopi.exercises.sorting;

public class Quicksort {

    public static void quicksortIntArray(int[] unsorted, int low, int high) {
        if (low < high) {
            int partition = lomutoPartition(unsorted, low, high);
            quicksortIntArray(unsorted, low, partition - 1);
            quicksortIntArray(unsorted, partition + 1, high);
        }
    }

    /**
     * This function takes last element as pivot, places the pivot element at its correct position in sorted
     * array, and places all smaller (smaller than pivot) to left of pivot and all greater elements to right
     * of pivot.
     */
    private static int lomutoPartition(int[] unsorted, int low, int high) {
        int pivot = unsorted[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (unsorted[j] < pivot) {
                i++;
                swap(unsorted, i, j);
            }
        }

        if (unsorted[high] < unsorted[i + 1]) {
            swap(unsorted, i + 1, high);
        }

        return i + 1;
    }

    /**
     *
     * @param unsorted
     * @param low
     * @param high
     * @return
     */
    private static int hoarePartition(int[] unsorted, int low, int high) {

        //TODO:
//        x = A[p]
//        i = p - 1
//        j = r + 1
//        while true
//        repeat
//                j = j - 1
//        until A[j] <= x
//                repeat
//        i = i + 1
//        until A[i] >= x
//        if i < j
//        swap( A[i], A[j] )
//    else
//        return j

        return 0;
    }

    private static void swap(int[] unsorted, int index1, int index2) {
        int temp = unsorted[index1];
        unsorted[index1] = unsorted[index2];
        unsorted[index2] = temp;
    }
}
