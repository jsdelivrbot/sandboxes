package PrimitiveTypes;


public class Exercise51 {
    private static short[] precomputedParity;

    static {
//        precomputedParity = new short[1 << 16];
//        for (int i = 0; i < (1 << 16); ++i) {
//            precomputedParity[i] = Exercise51.parity1(i);
//        }
    }

    public static void main(String[] args) {
//        int x = 42;
//        x = x & 0xFFFF;
        parity4(42);
    }

    public static short parity1(long x) {
        short result = 0;
        while (x != 0) {
            System.out.println("X before: " + x);
            result ^= (x & 1);
            System.out.println("result: " + result);
            x >>= 1;
            System.out.println("X after: " + x);
        }

        return result;
    }

    public static short parity2(long x) {
        short result = 0;
        while (x != 0) {
            result ^= 1;
            x &= (x - 1);       //erases the lowest set bit
        }
        return result;
    }

    //101010 => 42
    //101001 => 41
    //42&41 = 101000 = 40
    //39 = 100111
    //40&39 = 101000 & 100111 = 100000
    //31 = 011111

    public static short parity3(long x) {
        short test = (short) (precomputedParity[(int) ((x >> 48) & 0xFFFF)]
                ^ precomputedParity[(int) ((x >> 32) & 0xFFFF)]
                ^ precomputedParity[(int) ((x >> 16) & 0xFFFF)]
                ^ precomputedParity[(int) (x & 0xFFFF)]);
        return test;
    }

    public static short parity4(long x) {
        x ^= x >> 32;
        x ^= x >> 16;
        x ^= x >> 8;
        x ^= x >> 4;
        x &= 0xf;   //only want the last 4 bits of x

        //Return the LSB, which is the parity
        return (short) (fourBitParityLookup((int) x) & 1);
    }

    private static final int _fourBitParityLookupTable = 0x6996;    // = 0b0110100110010110

    private static short fourBitParityLookup(int x) {
        return (short) (_fourBitParityLookupTable >> x);
    }
}

//0101 & 1111 = 0101

//0011 ^ 0101 = 0110 = 6
//1000 & 0001 = 1001 = 9