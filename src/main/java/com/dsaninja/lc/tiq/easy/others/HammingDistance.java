package com.dsaninja.lc.tiq.easy.others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The Hamming distance between two integers is the number of
 * positions at which the corresponding bits are different.
 *
 * Given two integers x and y, return the Hamming distance between them.
 *
 * <a href="https://leetcode.com/problems/hamming-distance/">Problem-461</a>
 */
public class HammingDistance{
    public int hammingDistance(int x, int y) {
        int differentBits = x ^ y;
        int count = 0;

        // the only set bits will be different in x and y
        // so count the set bits
        while(differentBits != 0){
            count++;
            // set rightmost set bit to 0
            differentBits = differentBits & (differentBits - 1);
        }

        return count;
    }

    @Test
    public void testHammingDistance(){
        assertEquals(1, hammingDistance(2,3));
    }
}
