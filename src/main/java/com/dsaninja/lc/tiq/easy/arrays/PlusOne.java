package com.dsaninja.lc.tiq.easy.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * You are given a large integer represented as an integer array digits, where
 * each digits[i] is the ith digit of the integer. The digits are
 * ordered from most significant to the least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 * <pre>
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 *
 * Input: digits = [9]
 * Output: [1,0]
 * </pre>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
 */
public class PlusOne{
    public int[] plusOne(int[] digits){
        int index = digits.length - 1;

        while(index > 0){
            // star from the extreme right and for every 9
            // mark the index with 0 value and move to left
            if(digits[index] == 9){
                digits[index] = 0;
            }

            // otherwise, increment the current index location
            // and return
            else{
                digits[index]++;
                return digits;
            }
            index--;
        }

        // if reached here, it means all positions had 9
        // create a new array and initialize the left index 0
        // with 1
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    @Test
    @DisplayName("test plusOne for array with no 9")
    public void testPlusOne(){
        int[] result = plusOne(new int[]{1, 2, 3});
        assertArrayEquals(new int[]{1, 2, 4}, result);
    }

    @Test
    @DisplayName("test plusOne for array with a 9")
    public void testPlusOneWithNine(){
        int[] result = plusOne(new int[]{1, 2, 9});
        assertArrayEquals(new int[]{1, 3, 0}, result);
    }

    @Test
    @DisplayName("test plusOne for array with all 9")
    public void testPlusOneWithAllNine(){
        int[] result = plusOne(new int[]{9, 9, 9});
        assertArrayEquals(new int[]{1, 0, 0, 0}, result);
    }
}
