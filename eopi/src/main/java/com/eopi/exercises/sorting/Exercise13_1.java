package com.eopi.exercises.sorting;

import java.util.*;

class Exercise13_1 {

    static Integer[] computeIntersection(Integer[] arrayOne, Integer[] arrayTwo) {

        int indexOne = 0;
        int indexTwo = 0;

        List<Integer> intersection = new LinkedList<>();

        while (indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
            //If both values are equivalent, add to intersection and increment both indices
            if (arrayOne[indexOne].equals(arrayTwo[indexTwo])) {
                if (!intersection.contains(arrayOne[indexOne])) {
                    intersection.add(arrayOne[indexOne]);
                }
                indexOne++;
                indexTwo++;
            } else if (arrayOne[indexOne] < arrayTwo[indexTwo]) {
                //If value at indexOne < value at indexTwo, increment indexOne
                indexOne++;
            } else {
                //If value at indexTwo < value at indexOne, increment indexTwo
                indexTwo++;
            }
        }
        return intersection.toArray(new Integer[intersection.size()]);
    }
}
