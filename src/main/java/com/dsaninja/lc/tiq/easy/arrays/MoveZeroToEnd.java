package com.dsaninja.lc.tiq.easy.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an integer array nums, move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <pre>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * </pre>
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
 */
public class MoveZeroToEnd{

    public int[] moveZeroes(int[] nums){
        int slot = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[slot];
                nums[slot++] = nums[i];
                nums[i] = temp;
            }
        }

        return nums;
    }

    @Test
    @DisplayName("test move zero to end")
    public void testMove(){
        int[] updated = moveZeroes(new int[]{0, 1, 0, 3, 12});
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, updated);
    }
}
