package com.eopi.exercises.hashtables;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Exercise12_2Test {

    @Test
    public void isLetterConstructible_magazineHasEnoughCharacters_returnsTrue() {
        String magazineText = "i think this magazine text will have enough characters to construct the letter text.b";
        String letterText = "this letter text is constructible.";

        assertTrue(Exercise12_2.isLetterConstrucibleFromMagazine(magazineText, letterText));
    }

    @Test
    public void isLetterConstructible_magazineDoesNotHaveEnoughCharacters_returnsFalse() {
        String magazineText = "this magazine text will not be constructible.";
        String letterText = "this letter text is not constructible! qzwx";

        assertFalse(Exercise12_2.isLetterConstrucibleFromMagazine(magazineText, letterText));
    }
}
