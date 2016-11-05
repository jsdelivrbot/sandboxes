package com.algo.one.assignments.one;


import java.math.BigInteger;
import java.util.Arrays;

public class IntegerMultiplication {

    /**
     * Uses BigIntegers to multiply the two numbers.  Cheating, but can be used to verify the
     * correct result.
     */
    static String verify(String first, String second) {
        BigInteger firstInt = new BigInteger(first);
        BigInteger secondInt = new BigInteger(second);
        return firstInt.multiply(secondInt).toString();
    }

//    procedure karatsuba(num1, num2)
//  if (num1 < 10) or (num2 < 10)
//    return num1*num2
//  /* calculates the size of the numbers */
//            m = max(size_base10(num1), size_base10(num2))
//    m2 = m/2
//  /* split the digit sequences about the middle */
//    high1, low1 = split_at(num1, m2)
//    high2, low2 = split_at(num2, m2)
//  /* 3 calls made to numbers approximately half the size */
//    z0 = karatsuba(low1,low2)
//    z1 = karatsuba((low1+high1),(low2+high2))
//    z2 = karatsuba(high1,high2)
//  return (z2*10^(2*m2))+((z1-z2-z0)*10^(m2))+(z0)

//    For systems that need to multiply numbers in the range of several thousand digits, such as computer algebra
// systems and bignum libraries, long multiplication is too slow. These systems may employ Karatsuba multiplication,
// which was discovered in 1960 (published in 1962). The heart of Karatsuba's method lies in the observation that
// two-digit multiplication can be done with only three rather than the four multiplications classically required.
// This is an example of what is now called a divide and conquer algorithm.
// Suppose we want to multiply two 2-digit numbers: x1x2· y1y2:
//
//    compute x1 · y1, call the result A
//    compute x2 · y2, call the result B
//    compute (x1 + x2) · (y1 + y2), call the result C
//    compute C − A − B, call the result K; this number is equal to x1 · y2 + x2 · y1
//    compute A · 100 + K · 10 + B.

    /**
     * TODO: The actual assignment
     *
     */
    static int[] karatsuba_multiply(int[] first, int[] second) {
        if (first.length == 1 && second.length == 1) {
            return multiplyTwoSmallIntegers(first[0], second[0]);
        }

        int midpoint = findMidpointIndex(first, second);
        //IntArrayPair firstPair =

        int[] low1 = Arrays.copyOfRange(first, 0, midpoint - 1);
        int[] high1 = Arrays.copyOfRange(first, midpoint, first.length - 1);
        int[] low2 = Arrays.copyOfRange(second, 0, midpoint - 1);
        int[] high2 = Arrays.copyOfRange(second, midpoint, second.length - 1);

        int[] A = karatsuba_multiply(low1, low2);
        int[] B = karatsuba_multiply(high1, high2);
        int[] C = karatsuba_multiply(add(low1, high1), add(low2, high2));

        //K = C - A - B;
        int[] K = subtract(subtract(C, A), B);

        //(A * 100) + (K * 10) + B;
        return add(add(padZeroesRight(A, 2), padZeroesRight(K, 1)), B);
    }

    private static int[] multiplyTwoSmallIntegers(int first, int second) {
        int result = first * second;
        if (result >= 10) {
            return new int[] {result / 10, result % 10};
        }
        return new int[] { result };
    }

    /**
     * Converts a string into an integer array, each item in the array containing
     * a single digit integer representing a character of the input string (in order).
     */
    private static int[] convertStringRepresentation(String integerToConvert) {
        int[] retVal = new int[integerToConvert.length()];
        char[] charDigits = integerToConvert.toCharArray();

        for (int i = 0; i < retVal.length; i++) {
            retVal[i] = Character.digit(charDigits[i], Character.MAX_RADIX);
        }
        return retVal;
    }

    private static int findMidpointIndex(int[] first, int[] second) {
        int maxSize = Math.max(first.length, second.length);
        return maxSize / 2;
    }

    //TODO:
    private static int[] add(int[] first, int[] second) {
        return new int[]{};
    }

    //TODO:
    private static int[] subtract(int[] first, int[] second) {
        return new int[]{};
    }

    //TODO:
    private static int[] padZeroesRight(int[] value, int numberOfZeroesToPad) {
        return new int[]{};
    }
}
