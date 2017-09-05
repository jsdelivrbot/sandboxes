package com.eopi.exercises.searching;

import java.util.List;

public class BinarySearchUtil {

    public static int bsearch(int t, List<Integer> A) {
        int left = 0;
        int right = A.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //If element is larger than mid, search the right half of remaining subarray
            //Adjust left index to current midpoint
            if (A.get(mid) < t) {
                left = mid + 1;
            //If element is present at the midpoint, return it
            } else if (A.get(mid) == t) {
                return mid;
            //Element is smaller than mid, search left half of remaining subarray.
            //Adjust right index to current midpoint.
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    static int bsearchFirstOccurrence(int t, List<Integer> A) {
        int left = 0, right = A.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //If element is larger than mid, search the right half of remaining subarray
            //Adjust left index to current midpoint
            if (A.get(mid) < t) {
                left = mid + 1;
            //We've found an occurrence.  Now we need to find the first occurrence.
            } else if (A.get(mid) == t) {
                //We've found the first occurrence!
                if (isFirstOccurrence(t, A, mid)) {
                    return mid;
                }
                //First occurrence is smaller than mid, search left half of remaining subarray.
                //Adjust right index to current midpoint.
                //This will be treated as if our midpoint was to the right of the target index (we use the same logic
                //for both cases).
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static boolean isFirstOccurrence(int t, List<Integer> A, int index) {
        return A.get(index) == t && (index == 0 || A.get(index - 1) != t);
    }
}
