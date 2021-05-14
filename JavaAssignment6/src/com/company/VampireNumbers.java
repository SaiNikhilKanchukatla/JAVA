package com.company;
import java.util.Arrays;
import java.util.HashSet;
public class VampireNumbers {
    private static int numDigits(long num) {
        return Long.toString(Math.abs(num)).length();
    }

    private static boolean factCheck(long orig, long fang1, long fang2) {
        if (Long.toString(fang1).endsWith("0") && Long.toString(fang2).endsWith("0")) return false;

        int origLen = numDigits(orig);
        if (numDigits(fang1) != origLen / 2 || numDigits(fang2) != origLen / 2) return false;

        byte[] origBytes = Long.toString(orig).getBytes();
        byte[] fangBytes = (Long.toString(fang1) + Long.toString(fang2)).getBytes();
        Arrays.sort(origBytes);
        Arrays.sort(fangBytes);
        return Arrays.equals(origBytes, fangBytes);
    }

    public void printVampireNumbers() {
        //Vampire Numbers Driver Code to print first 100 vampire numbers
        HashSet<Long> vampireNumbers = new HashSet<Long>();
        for (long i = 100; vampireNumbers.size() < 99; i++) {
            if ((numDigits(i) % 2) != 0) {
                i = i * 10 - 1;
                continue;
            }
            for (long fact1 = 2; fact1 <= Math.sqrt(i) + 1; fact1++) {
                if (i % fact1 == 0) {
                    long fact2 = i / fact1;
                    if (factCheck(i, fact1, fact2) && fact1 <= fact2) {
                        vampireNumbers.add(i);
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
