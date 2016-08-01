package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestImpl {

	private static final Logger log = LoggerFactory.getLogger(TestImpl.class);

	public void testMethod1() {
		log.info("testMethod1 entered");
	}

	public void testMethod2() {
		log.info("testMethod2 entered");
	}
}
