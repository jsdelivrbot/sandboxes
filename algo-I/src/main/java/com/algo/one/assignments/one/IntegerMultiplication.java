package com.algo.one.assignments.one;


import java.math.BigInteger;

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

    /**
     * TODO: The actual assignment
     */
    static int[] multiply(int[] first, int[] second) {
        if (first.length > 1 || second.length > 1) {
            //TODO: multiply without recursion
        }

        int n = max(size_base10(first), size_base10(second));
        int n2 = n / 2;

        int[] p0 = multiply();
        int[] p1 = multiply();
        int[] p2 = multiply();

        return (p2 * 10^(2*n2)) + ((p1 - p2 - p0) * 10^(n2)) + p0;
    }

    /**
     * Converts a string into an integer array, each item in the array containing
     * a single digit integer representing a character of the input string (in order).
     */
    static int[] convertStringRepresentation(String integerToConvert) {
        int[] retVal = new int[integerToConvert.length()];
        char[] charDigits = integerToConvert.toCharArray();

        for (int i = 0; i < retVal.length; i++) {
            retVal[i] = Character.digit(charDigits[i], Character.MAX_RADIX);
        }
        return retVal;
    }

    //TODO:
    private static int[] add(int[] first, int[] second) {

    }

//    private static boolean isLessThan10(int[] numberToCheck) {
//        if (numberToCheck.length > 2) {
//            return false;
//        }
//        if (numberToCheck.length == 2 && (numberToCheck[0] > 1 && numberToCheck[1] > 0)) {
//            return false;
//        }
//
//        return true;
//    }
}
