package com.eopi.exercises.searching;

public class Exercise11_4 {

    /**
     * Returns the largest integer whose square is less than or equal to k.
     * It uses a binary search to find the integer between 0 and (k / 2) which satisfies this condition - we start with
     * k / 2 as any integer between (k/2 - k) would be larger than the square of k, which saves us one iteration.
     *
     * Has O(log n) runtime performance.
     *
     * Example: k = 4 will return 16.
     */
    static int computeIntegerSquareRoot(int k) {
        int left = 0;
        int right = k / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int square = mid * mid;

            if (square < k - mid) {
                left = mid + 1;
            } else if (square > k) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return k;
    }
}
