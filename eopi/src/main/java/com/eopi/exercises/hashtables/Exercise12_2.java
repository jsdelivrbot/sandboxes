package com.eopi.exercises.hashtables;

import java.util.HashMap;
import java.util.Map;

public class Exercise12_2 {

    /**
     * Returns true if the characters (and their frequency) in magazineText can be used as a source for constructing the
     * letterText string.  If letterText contains characters that are not in magazineText (or contains a higher frequency of
     * any character relative to magazineText), this method will return false.
     */
    static boolean isLetterConstrucibleFromMagazine(String magazineText, String letterText) {
        Map<Character, Integer> magazineCharacterCount = getCharacterCount(magazineText);

        //Iterate through each character in letterText, decrementing the character count in the map of characters that we
        //calculated from magazineText.  If at any point the map either does not contain that character or has a
        // frequency < 0 for that character, we know that we do not have enough characters to construct the letter.
        for (char letterCharacter : letterText.toCharArray()) {
            if (!magazineCharacterCount.containsKey(letterCharacter) ||
                    magazineCharacterCount.get(letterCharacter).equals(0)) {
                System.out.println("Not enough " + letterCharacter + " characters in magazineText to construct the letter!");
                return false;
            }
            magazineCharacterCount.put(letterCharacter, magazineCharacterCount.get(letterCharacter) - 1);
        }

        return true;
    }

    /**
     * Calculates the frequency of each character in the given string.
     */
    private static Map<Character, Integer> getCharacterCount(String text) {

        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (char character : text.toCharArray()) {
            if (!characterCountMap.containsKey(character)) {
                characterCountMap.put(character, 1);
            } else {
                characterCountMap.put(character, characterCountMap.get(character) + 1);
            }
        }

        return characterCountMap;
    }
}
