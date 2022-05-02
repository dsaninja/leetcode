package com.dsaninja.lc.tiq.easy.others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * <a href="https://leetcode.com/problems/reverse-bits/">Problem-190</a>
 */
public class ReverseBits{
    public int reverseBits(int n) {
        int mask = 1;

        // Update the first number
        int result = 0;

        // the length is guaranteed to be 32 -> 32 iteration
        for(int i = 1; i <= 32; i++){
            // this will return the last bit of the binary representation
            // Ex: 101 & 1 -> 1, 100 & 1 -> 0
            int lastBit = n & mask;

            // this will remove the lastBit from the binary string.
            // Ex: 100 >>= 1 -> 10, 1101  >>= 1 -> 110
            n >>=1;

            // this will add 1 zero into the result.
            // Ex: 1 <<=1 -> 10; 11101 <<= 1 -> 111010
            result <<= 1;

            // add the digit
            result += lastBit;
        }
        return result;
    }

    @Test
    public void testReverseBits(){
        assertEquals(964176192, reverseBits(43261596));
    }
}
