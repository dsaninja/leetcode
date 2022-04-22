package com.dsaninja.lc.tiq.easy.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum. A subarray is a contiguous part of an array.
 *
 * <a href="https://leetcode.com/problems/maximum-subarray/">Problem-53</a>
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currMax = 0;
        for (int elem : nums) {
            currMax = currMax + elem;
            currMax = Math.max(currMax, elem);
            max = Math.max(max, currMax);
        }

        return max;
    }

    @Test
    public void testMaximumSubarray() {
        assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
