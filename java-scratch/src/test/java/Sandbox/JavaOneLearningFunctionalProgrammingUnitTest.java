package Sandbox;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JavaOneLearningFunctionalProgrammingUnitTest {

	@Test
	public void completableFuture_isOk() throws Exception {
		String val = JavaOneLearningFunctionalProgramming.completableFutureTest();
		assertEquals(val, "Present");
	}

	@Test
	public void parallelStreams_isOk() throws Exception {
		JavaOneLearningFunctionalProgramming.parallelStreamsTest();
	}
}
