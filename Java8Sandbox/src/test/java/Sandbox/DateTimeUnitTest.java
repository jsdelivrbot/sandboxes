package Sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by dustinstanley on 2/22/15.
 */
public class DateTimeUnitTest {

    @Test
    public void DateTimeTest() {
        LocalDate localDate = LocalDate.of(2010, 5, 10);
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime.atZone(ZoneId.of("America/Los_Angeles"));
    }

    @Test
    public void dowTest() {
        int[] monthDayCalc = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};

        int day = 1;
        int month = 1;
        int year = 2015;

        if (month < 3) {
            year -= 1;
        }
        //year -= month < 3;
        Assert.assertEquals((year + (year / 4) - (year / 100) + (year / 400) + monthDayCalc[month - 1] + day) % 7, 4);
    }
}
