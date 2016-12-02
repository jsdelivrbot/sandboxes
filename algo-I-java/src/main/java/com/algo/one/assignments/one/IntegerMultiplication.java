package com.algo.one.assignments.one;


import com.google.common.primitives.Ints;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;

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


    /**
     * The actual karatsuba implementation
     *
     */
    static int[] karatsuba_multiply(int[] first, int[] second) {
        System.out.println("karatsuba_multiply: " + Arrays.toString(first) + " " + Arrays.toString(second));
        if (first.length == 0 || second.length == 0) {
            return new int[] { 0 };
        }
        if (first.length == 1 || second.length == 1) {
            return multiplyTwoSmallIntegers(first, second);
        }

        int maxLength = Math.max(first.length, second.length);
        int midpoint = maxLength / 2;

        int[] low1 = Arrays.copyOfRange(first, 0, first.length - midpoint);
        int[] high1 = Arrays.copyOfRange(first, first.length - midpoint, first.length);
        int[] low2 = Arrays.copyOfRange(second, 0, second.length - midpoint);
        int[] high2 = Arrays.copyOfRange(second, second.length - midpoint, second.length);

        int[] ac = karatsuba_multiply(low1, low2);
        int[] bd = karatsuba_multiply(high1, high2);
        int[] C = karatsuba_multiply(add(low1, high1), add(low2, high2));

        //ad_plus_bc = C - ac - bd;
        int[] ad_plus_bc = subtract(subtract(C, ac), bd);

        return add(add(padZeroesRight(ac, 2 * midpoint), padZeroesRight(ad_plus_bc, midpoint)), bd);
    }

    private static int[] multiplyTwoSmallIntegers(int[] first, int[] second) {
        StringBuilder firstStr = new StringBuilder(first.length);
        StringBuilder secondStr = new StringBuilder(second.length);
        for (int digit : first) {
            firstStr.append(digit);
        }
        for (int digit : second) {
            secondStr.append(digit);
        }

        Integer multiple = Integer.parseInt(firstStr.toString()) * Integer.parseInt(secondStr.toString());
        return convertStringRepresentation(multiple.toString());
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

    static String convertIntArrayRepresentation(int[] arrayToConvert) {
        StringBuilder result = new StringBuilder(arrayToConvert.length);
        for (int digit : arrayToConvert) {
            result.append(digit);
        }
        return result.toString();
    }

    private static int[] add(int[] first, int[] second) {
        int[] firstPadded = first.clone();
        int[] secondPadded = second.clone();
        if (first.length < second.length) {
            firstPadded = padZeroesLeft(first, second.length - first.length);
        } else if (second.length < first.length) {
            secondPadded = padZeroesLeft(second, first.length - second.length);
        }

        LinkedList<Integer> tempResult = new LinkedList<>();

        int carry = 0;
        for (int i = firstPadded.length - 1; i >= 0; i--) {
            int temp = firstPadded[i] + secondPadded[i] + carry;
            if (temp >= 10) {
                tempResult.push(temp - 10);
                carry = 1;
            } else {
                tempResult.push(temp);
                carry = 0;
            }
        }
        if (carry == 1) {
            tempResult.push(1);
        }

        return Ints.toArray(tempResult);
    }

    static int[] subtract(int[] first, int[] second) {
        int[] firstPadded = first.clone();
        int[] secondPadded = second.clone();
        if (first.length < second.length) {
            firstPadded = padZeroesLeft(first, second.length - first.length);
        } else if (second.length < first.length) {
            secondPadded = padZeroesLeft(second, first.length - second.length);
        }
        LinkedList<Integer> tempResult = new LinkedList<>();

        int carry = 0;
        for (int i = firstPadded.length - 1; i >= 0; i--) {
            int temp = firstPadded[i] - secondPadded[i] - carry;
            if (temp < 0) {
                tempResult.push(temp + 10);
                carry = 1;
            } else {
                tempResult.push(temp);
                carry = 0;
            }
        }

        return Ints.toArray(tempResult);
    }

    private static int[] padZeroesRight(int[] value, int numberOfZeroesToPad) {
        return Arrays.copyOf(value, value.length + numberOfZeroesToPad);
    }

    private static int[] padZeroesLeft(int[] value, int numberOfZeroesToPad) {
        LinkedList<Integer> temp = new LinkedList<>(Ints.asList(value));
        for (int i = 0; i < numberOfZeroesToPad; i++) {
            temp.push(0);
        }
        return Ints.toArray(temp);
    }
}
