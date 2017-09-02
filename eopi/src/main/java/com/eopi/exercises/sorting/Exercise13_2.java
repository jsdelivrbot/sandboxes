package com.eopi.exercises.sorting;

public class Exercise13_2 {

    /**
     * Returns a merged array which contains the non-null values of arrayOne and arrayTwo in sorted order.
     * NOTE: This method assumes that arrayOne is large enough to contain all of the non-null values of both
     * arrayOne and arrayTwo!
     *
     * This implementation tries to be as space efficient as possible and does not allocate any additional
     * space for temporary storage of array values.
     */
    static Integer[] mergeSortedArrays(Integer[] arrayOne, Integer[] arrayTwo) {

        int arrayOneInitialSize = getCountOfNonNullEntries(arrayOne);
        int arrayTwoInitialSize = getCountOfNonNullEntries(arrayTwo);

        //Iterate backwards through the both arrays, overwriting values in array one as necessary.  We write backwards
        //so that we fill the empty slots of the array first, making efficient use of the memory allocated to the array
        //and preserving the values at the beginning of the array for comparison later.
        int indexOne = arrayOneInitialSize - 1;
        int indexTwo = arrayTwoInitialSize - 1;
        int writeIndex = arrayOneInitialSize + arrayTwoInitialSize - 1;

        while (writeIndex >= 0 && indexTwo >= 0) {
            if (indexOne < 0 || arrayTwo[indexTwo] >= arrayOne[indexOne]) {
                arrayOne[writeIndex] = arrayTwo[indexTwo];
                indexTwo--;
            } else if (arrayOne[indexOne] > arrayTwo[indexTwo]) {
                arrayOne[writeIndex] = arrayOne[indexOne];
                indexOne--;
            }

            writeIndex--;
        }

        return arrayOne;
    }

    /**
     * Returns the number of non-null entries in the given array.
     */
    private static int getCountOfNonNullEntries(Integer[] array) {
        int nonNullEntries = 0;
        while (nonNullEntries < array.length && array[nonNullEntries] != null) {
            nonNullEntries++;
        }
        return nonNullEntries;
    }
}
