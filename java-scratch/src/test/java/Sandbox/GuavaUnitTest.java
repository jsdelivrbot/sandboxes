package Sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.common.collect.*;

import java.util.List;

/**
 * Created by dustinstanley on 2/22/15.
 */
public class GuavaUnitTest {

	@Test()
	public void CollectionsTest() {
		List<String> strings = Lists.newArrayList("test1", "test2", "test3");

		Assert.assertEquals("test1", strings.get(0));
		Assert.assertEquals("test2", strings.get(1));
		Assert.assertEquals("test3", strings.get(2));


	}

	@Test()
	public void FunctionalTest() {

	}
}
