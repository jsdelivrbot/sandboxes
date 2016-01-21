package Sandbox;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class LambdaExpressionsUnitTest {

	@BeforeClass
	public void setUp() {
		System.out.println("LambdaExpressionsUnitTest Setup");
		// code that will be invoked when this test is instantiated
	}

	@Test()
	public void runLambdasTest() {
		try {
			LambdaExpressions.runLambdas();
			Assert.assertTrue(true);
		} catch (Exception ex) {
			System.out.println("Exception occurred running runLambdasTest(): " + ex.getStackTrace());
			Assert.fail();
		}
	}

	@Test()
	public void streamsTest() {
		try {
			List<String> myList =
					Arrays.asList("a1", "a2", "b1", "c2", "c1");

			myList.
					stream()
					.filter(s -> s.startsWith("c"))
					.map(String::toUpperCase)
					.sorted()
					.forEach(System.out::println);
//			String[] names = {"Sam","Pamela", "Dave", "Pascal", "Erik"};
//			List<String> filteredNames = stream(names)
//					.filter(c -> c.contains("am"))
//					.collect(toList());

//			List<Integer> transactionsIds =
//					transactions.stream()
//							.filter(t -> t.getType() == Transaction.GROCERY)
//							.sorted(comparing(Transaction::getValue).reversed())
//							.map(Transaction::getId)
//							.collect(toList());
		} catch (Exception ex) {
			System.out.println("Exception occurred running streamsTest(): " + ex.getStackTrace());
			Assert.fail();
		}
	}
}
