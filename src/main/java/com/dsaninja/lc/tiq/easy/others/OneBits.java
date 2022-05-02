package com.dsaninja.lc.tiq.easy.others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function that takes an unsigned integer and returns the number
 * of '1' bits it has (also known as the Hamming weight).
 *
 * <a href="https://leetcode.com/problems/number-of-1-bits/">Problem-191</a>
 */
public class OneBits{
    // Brian Kernighan's Algorithm
    public int hammingWeight(int n){
        int count = 0;
        while(n != 0){
            // set rightmost set bit to 0
            n = n & (n - 1);
            count++;
        }

        return count;
    }
    
    @Test
    public void testOneBits(){
        assertEquals(2, hammingWeight(3));
    }
}
