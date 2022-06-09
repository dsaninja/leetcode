package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given a 1-indexed array of integers numbers that is already sorted
 * in non-decreasing order, find two numbers such that they add up to
 * a specific target number. Let these two numbers be numbers[index1] and
 * numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as
 * an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may
 * not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 *
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Problem-167</a>
 */
public class TwoSumII{
    public int[] twoSum(int[] numbers, int target) {
        int start  = 0;
        int end = numbers.length -1;

        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                return new int[]{start+1, end+1};
            }

            if(sum > target){
                end--;
            }else{
                start++;
            }
        }

        // should never reach here as
        // per statement
        return null;
    }

    @Test
    public void testSum(){
        assertArrayEquals(new int[]{1,2}, twoSum(new int[]{2,7,11,15}, 9));
    }
}
