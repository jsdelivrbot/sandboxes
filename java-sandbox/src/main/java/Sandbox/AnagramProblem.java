package Sandbox;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dustinstanley on 8/16/15.
 */
public class AnagramProblem {

	public static boolean isAnagram(String firstWord, String secondWord) {

		if (firstWord.equals(secondWord)) {
			return true;
		}
		if (firstWord.length() != secondWord.length()) {
			return false;
		}

		Map<Character, Integer> firstMap = createCharMapFromWord(firstWord);
		Map<Character, Integer> secondMap = createCharMapFromWord(secondWord);

		for (Character character : firstMap.keySet()) {
			if (secondMap.containsKey(character) &&
					secondMap.get(character).equals(firstMap.get(character))) {
				continue;
			} else {
				return false;
			}
		}

		for (Character character : secondMap.keySet()) {
			if (firstMap.containsKey(character) &&
					firstMap.get(character).equals(secondMap.get(character))) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	/**
	 *
	 * @param word
	 * @return
	 */
	private static Map<Character, Integer> createCharMapFromWord(String word) {
		Map<Character, Integer> retVal = new HashMap<Character, Integer>();
		for (char character : word.toCharArray()) {
			if (!retVal.containsKey(character)) {
				retVal.put(character, 0);
			}
			retVal.put(character, retVal.get(character) + 1);
		}
		return retVal;
	}
}
