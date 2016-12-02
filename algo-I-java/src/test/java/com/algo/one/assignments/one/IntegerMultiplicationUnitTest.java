package com.algo.one.assignments.one;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerMultiplicationUnitTest {

    private static final String firstValueStr = "3141592653589793238462643383279502884197169399375105820974944592";
    private static final String secondValueStr = "2718281828459045235360287471352662497757247093699959574966967627";
    private static final int[] firstValueInt = IntegerMultiplication.convertStringRepresentation(firstValueStr);
    private static final int[] secondValueInt = IntegerMultiplication.convertStringRepresentation(secondValueStr);

    @Test
    public void assignmentVerificationTest() {
        System.out.println(IntegerMultiplication.verify(firstValueStr, secondValueStr).toString());
    }

    @Test
    public void simpleVerificationTest() {
        assertEquals(IntegerMultiplication.verify("1234", "5678"), "7006652");
    }

    public void karatsuba_multiplyAndVerify(String first, String second) {
        String result = IntegerMultiplication.convertIntArrayRepresentation(
                IntegerMultiplication.karatsuba_multiply(
                        IntegerMultiplication.convertStringRepresentation(first),
                        IntegerMultiplication.convertStringRepresentation(second)));
        String expected = IntegerMultiplication.verify(first, second);
        assertEquals(expected, result);
    }

    @Test
    public void karatsuba_multiply_simpletest() {
        karatsuba_multiplyAndVerify("1234", "5678");
    }

    @Test
    public void karatsuba_multiply_mismatchNumDigitsTest() {
        karatsuba_multiplyAndVerify("46", "134");
    }

    @Test
    public void karatsuba_multiply_fulltest() {
        karatsuba_multiplyAndVerify(firstValueStr, secondValueStr);
    }

    @Test
    public void karatsuba_multiply_sixDigits() {
        karatsuba_multiplyAndVerify("6756", "567");
    }

    @Test
    public void karatsuba_multiply_est() {
        karatsuba_multiplyAndVerify("123", "63");
    }

    @Test
    public void karatsuba_BigInteger_timeTest() {
        IntegerMultiplication.verify(firstValueStr, secondValueStr);
    }

    @Test
    public void karatsuba_multiply_timeTest() {
        IntegerMultiplication.karatsuba_multiply(firstValueInt, secondValueInt);
    }
}
