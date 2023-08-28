package com.dsaninja.lc.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a binary array nums and an integer k,
 * return the maximum number of consecutive 1's in
 * the array if you can flip at most k 0's.
 *
 * <a href="https://leetcode.com/problems/max-consecutive-ones-iii/">Max Consecutive Ones III</a>
 */
public class MaxConsecutiveOnes {

    @Test
    @DisplayName("test longest ones method")
    public void testLongestOnes(){
        assertEquals(6, longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        assertEquals(10, longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;

        int zeros = 0;
        int max = 0;

        while (right < nums.length){
            if(nums[right] == 0){
                zeros++;
            }

            while (zeros > k){
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
