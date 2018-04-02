package com.eopi.exercises.strings;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Exercise6_2Test {

    @DataProvider
    private Object[][] convertBaseProvider() {
        return new Object[][] {
                {"", 16, 10, ""}
        };
    }

    @Test(dataProvider = "convertBaseProvider")
    public void convertBase_isOk(String input, int baseOne, int baseTwo, String expected) {
        assertEquals(Exercise6_2.convertBase(input, baseOne, baseTwo), expected);
    }
}
