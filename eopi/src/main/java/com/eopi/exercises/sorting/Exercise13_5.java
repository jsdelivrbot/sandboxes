package com.eopi.exercises.sorting;

import java.util.ArrayList;
import java.util.List;

class Exercise13_5 {

    /**
     * Returns the maximum number of events in the given list that occur concurrently based on their start/end times.
     */
    static int calculateMaxConcurrentEvents(List<Event> events) {

        List<Endpoint> endpoints = new ArrayList<>(events.size() * 2);
        events.forEach(event -> {
            endpoints.add(new Endpoint(event.start, true));
            endpoints.add(new Endpoint(event.end, false));
        });

        endpoints.sort((e1, e2) -> {
            if (e1.time == e2.time) {
                if (e1.isStart == e2.isStart) {
                    return 0;
                } else if (e1.isStart) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return Integer.compare(e1.time, e2.time);
        });

        //Takes the sorted list of endpoints and iterates through them, incrementing a counter when a "start endpoint" is hit
        //and decrementing the same counter when an "end endpoint" is hit.  The highest value of this counter is then returned.
        int maxConcurrentEvents = 0;
        int concurrentEvents = 0;
        for (Endpoint endpoint : endpoints) {
            if (endpoint.isStart) {
                concurrentEvents++;
                maxConcurrentEvents = Math.max(maxConcurrentEvents, concurrentEvents);
            } else {
                concurrentEvents--;
            }
        }

        return maxConcurrentEvents;
    }

    /**
     * Used to distill Events down to their start/end times, which are then sorted.
     */
    private static class Endpoint {
        private final int time;
        private final boolean isStart;

        private Endpoint(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
}
