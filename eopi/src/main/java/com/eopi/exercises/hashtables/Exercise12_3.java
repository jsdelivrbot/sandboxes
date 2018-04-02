package com.eopi.exercises.hashtables;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class represents an ISBN cache for 10-digit ISBN numbers.
 */
public class Exercise12_3 {

    private final LinkedHashMap<Integer, Integer> isbnPriceCache;

    public Exercise12_3(int capacity) {
        isbnPriceCache = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return this.size() > capacity;
            }
        };
    }
}
