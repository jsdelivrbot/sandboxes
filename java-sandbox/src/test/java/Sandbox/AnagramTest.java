package Sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by dustinstanley on 8/16/15.
 */
public class AnagramTest {

	@Test
	public void isAnagram_whenAnagrams_returnsTrue() {
		Assert.assertTrue(AnagramProblem.isAnagram("dustin", "nustdi"));
	}

	@Test
	public void isAnagram2_whenAnagrams_returnsTrue() {
		Assert.assertTrue(AnagramProblem.isAnagram("votes", "stove"));
	}

	@Test
	public void isAnagram3_whenAnagrams_returnsTrue() {
		Assert.assertTrue(AnagramProblem.isAnagram("vases", "saves"));
	}

	@Test
	public void isAnagram_whenNotAnagrams_returnsFalse() {
		Assert.assertFalse(AnagramProblem.isAnagram("dustin", "chloe"));
	}
}
