package Sandbox;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by dustinstanley on 2/22/15.
 */
public class DateTimeUnitTest {

	@Test()
	public void DateTimeTest() {
		LocalDate localDate = LocalDate.of(2010, 5, 10);
		LocalDateTime localDateTime = LocalDateTime.now();
		localDateTime.atZone(ZoneId.of("America/Los_Angeles"));
	}
}
