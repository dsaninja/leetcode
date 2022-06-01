package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a binary array nums, return the maximum number of consecutive
 * 1's in the array if you can flip at most one 0.
 *
 * <pre>
 * Input: nums = [1,0,1,1,0]
 * Output: 4
 * Explanation: Flip the first zero will get the maximum number of consecutive 1s.
 * After flipping, the maximum number of consecutive 1s is 4.
 * </pre>
 *
 * <a href="https://leetcode.com/problems/max-consecutive-ones-ii/">Problem-487</a>
 */
public class MaxConsecutiveOnesV2{

    // Time complexity : O(n) Since both the pointers only move forward,
    // each of the left and right pointer traverse a maximum of n steps.
    // Therefore, the time complexity is O(n)
    public int slidingWindow(int[] input){

        // start with two pointers both
        // pointing to first element
        int left = 0;
        int right = 0;

        int max = Integer.MIN_VALUE;
        int zeros = 0;

        while(right < input.length){

            // if right points to a zero
            // increment the zero count
            if(input[right] == 0){
                zeros++;
            }

            // check if there are two zeros
            // encountered
            while(zeros == 2){
                // now if left also points to zero
                // we will slide the eligible window to right
                // excluding the left element

                // this step is repeated until left
                // crosses over a zero to reduce
                // the zero count
                if(input[left] == 0){
                    zeros--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);

            // sh
            right++;
        }

        return max;
    }

    // O(n^2)
    public int bruteForce(int[] input){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < input.length; i++){
            int zeroCount = 0;
            for(int j = i; j < input.length; j++){
                if(input[j] == 0){
                    zeroCount++;
                }

                // the check is not on zeroCount == 2 for inputs
                // that only has 1 zero ex: 1,1,0,1
                if(zeroCount <= 1){
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }

    @Test
    public void testBruteForce(){
        assertEquals(4, bruteForce(new int[]{1, 0, 1, 1, 0}));
        assertEquals(4, bruteForce(new int[]{1, 0, 1, 1, 0, 1}));
        assertEquals(4, bruteForce(new int[]{1, 1, 0, 1}));

    }

    @Test
    public void testSlidingWindow(){
        assertEquals(4, slidingWindow(new int[]{1, 0, 1, 1, 0}));
        assertEquals(4, slidingWindow(new int[]{1, 0, 1, 1, 0, 1}));
        assertEquals(4, slidingWindow(new int[]{1, 1, 0, 1}));

    }
}
