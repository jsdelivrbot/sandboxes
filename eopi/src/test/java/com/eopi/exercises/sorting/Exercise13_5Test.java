package com.eopi.exercises.sorting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Exercise13_5Test {

    @DataProvider
    public Object[][] eventProvider() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(1, 5));
        events.add(new Event(6, 10));
        events.add(new Event(11, 13));
        events.add(new Event(14, 15));
        events.add(new Event(2, 7));
        events.add(new Event(8, 9));
        events.add(new Event(12, 15));
        events.add(new Event(4, 5));
        events.add(new Event(9, 17));
        return new Object[][] {
                {events, 3}
        };
    }

    @Test(dataProvider = "eventProvider")
    public void stableSortList_isOk(List<Event> events, int expectedMax) {
        assertEquals(Exercise13_5.calculateMaxConcurrentEvents(events), expectedMax);
    }
}
