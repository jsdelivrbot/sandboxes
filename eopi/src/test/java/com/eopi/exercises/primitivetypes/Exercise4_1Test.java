package com.eopi.exercises.primitivetypes;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise4_1Test {

    private final Exercise4_1 ref = new Exercise4_1();

    @DataProvider(name = "longProvider")
    public static Object[][] longDataProvider() {
        return new Object[][]{
                {Long.MAX_VALUE},
                {Long.MIN_VALUE},
                {-124124L},
                {1423235423L},
                {4353L},
                {0}
        };
    }

    @Test(dataProvider = "longProvider")
    public void computeParityOfWord_givenWord_isOk(long word) {
        System.out.println(word + " long binary: " + Long.toBinaryString(word) + " bit count: " + Long.bitCount(word));
        assertThat(ref.computeParityOfWord(word)).isEqualTo((short)(Long.bitCount(word) % 2));
    }
}
