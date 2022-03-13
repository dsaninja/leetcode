package com.dsaninja.lc.tiq.easy.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an array, rotate the array to the right by k steps,
 * where k is non-negative.
 *
 * <pre>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * </pre>
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/646/
 */
public class RotateArray{
    public int[] rotate(int[] nums, int k){
        k = k % nums.length; // to ensure range
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        return nums;
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    @Test
    @DisplayName("test rotating an array")
    public void testRotate(){
        int[] rotated = rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, rotated);
    }

    @Test
    @DisplayName("test rotating an array - v2")
    public void testRotateV2(){
        int[] rotated = rotate(new int[]{-1, -100, 3, 99}, 2);
        assertArrayEquals(new int[]{3, 99, -1, -100}, rotated);
    }
}
