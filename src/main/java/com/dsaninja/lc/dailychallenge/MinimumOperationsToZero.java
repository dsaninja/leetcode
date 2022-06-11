package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given an integer array nums and an integer x.
 * In one operation, you can either remove the leftmost or the
 * rightmost element from the array nums and subtract its value from x.
 * Note that this modifies the array for future operations.
 * <p>
 * Return the minimum number of operations to reduce x to exactly 0
 * if it is possible, otherwise, return -1.
 *
 * <a href="https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/2136570/Change-Your-Perspective-or-JAVA-Explanation">Explanation</a>
 *
 * <p>
 * <a href="https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/">Problem-1658</a>
 */
public class MinimumOperationsToZero{
    public int minOperations(int[] nums, int x){
        int sum = Arrays.stream(nums).sum();
        int maxLength = -1;

        int currentSum = 0;
        int left = 0;
        int right = 0;

        while(right < nums.length){
            currentSum += nums[right];

            while(left <= right && currentSum > sum - x){
                currentSum -= nums[left];
                left++;
            }

            if(currentSum == sum - x){
                maxLength = Math.max(maxLength, right - left + 1);
            }

            right++;
        }

        return maxLength != -1 ? nums.length - maxLength : -1;

    }

    @Test
    public void testMinOps(){
        assertEquals(2, minOperations(new int[]{1, 4, 2, 3}, 5));
        assertEquals(-1, minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        assertEquals(5, minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }
}
