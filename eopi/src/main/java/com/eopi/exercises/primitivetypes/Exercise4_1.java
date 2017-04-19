package com.eopi.exercises.primitivetypes;


import java.util.HashMap;
import java.util.Map;

public class Exercise4_1 {

    final Map<Short, Short> parityMap = new HashMap<>();

    public Exercise4_1() {
        initializeParityMap();
    }

    private void initializeParityMap() {
        for (short i = Short.MIN_VALUE; i < Short.MAX_VALUE; i++) {
            parityMap.put(i, computeParityOfShortSlowly(i));
        }
        parityMap.put(Short.MAX_VALUE, computeParityOfShortSlowly(Short.MAX_VALUE));
    }

    /**
     * Calculates parity of a 64-bit word by splitting the word into 4 equal pieces, calculating
     * the parity of each piece via the cached lookup map.
     */
    public short computeParityOfWord(long word) {
        short first = (short)word;
        short second = (short)(word >>= 16);
        short third = (short)(word >>= 16);
        short fourth = (short)(word >> 16);

        return (short)((parityMap.get(first) +
                parityMap.get(second) +
                parityMap.get(third) +
                parityMap.get(fourth)) %
                2);
    }

    /**
     * Naive (slow) implementation of computing the parity of a short
     */
    private short computeParityOfShortSlowly(short chunk) {
        short numBits = 0;
        while (chunk != 0) {
            numBits += (chunk & 1);
            //Operands for bitshift operations are sign-extended to ints before shifting,
            //so need to zero out the higher 16-bit section of that int
            chunk = (short)((0x0000FFFF & chunk) >> 1);
        }
        return (short)(numBits % 2);
    }

    private short computeParityOfShortQuickly(short chunk) {
        //TODO: implement
        return -1;
    }
}
