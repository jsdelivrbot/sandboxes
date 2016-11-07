package com.algo.one.assignments.one;


import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

public class IntegerMultiplicationUnitTest {

    private static final String firstValueStr = "3141592653589793238462643383279502884197169399375105820974944592";
    private static final String secondValueStr = "2718281828459045235360287471352662497757247093699959574966967627";

    private static final String simpleFirstValueStr = "1234";
    private static final String simpleSecondValueStr = "5678";

    @Test
    public void assignmentVerificationTest() {
        //Double firstValue = Double.parseDouble(firstValueStr);
        //Double secondValue = firstValue / 1000000000000000000000000000000000000000000000000000000000000000d;
        System.out.println(IntegerMultiplication.verify(firstValueStr, secondValueStr).toString());
    }

    @Test
    public void simpleVerificationTest() {
        Assert.assertEquals(IntegerMultiplication.verify("1234", "5678"), "7006652");
    }

    @Test
    public void karatsuba_multiply_fulltest() {
        int[] result = IntegerMultiplication.karatsuba_multiply(
                IntegerMultiplication.convertStringRepresentation(firstValueStr),
                IntegerMultiplication.convertStringRepresentation(secondValueStr));
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void karatsuba_multiply_simpletest() {
        int[] result = IntegerMultiplication.karatsuba_multiply(
                IntegerMultiplication.convertStringRepresentation("1234"),
                IntegerMultiplication.convertStringRepresentation("5678"));
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void karatsuba_multiply_mismatchNumDigitsTest() {
        int[] result = IntegerMultiplication.karatsuba_multiply(
                IntegerMultiplication.convertStringRepresentation("46"),
                IntegerMultiplication.convertStringRepresentation("134"));
        System.out.println(Arrays.toString(result));
    }
}
