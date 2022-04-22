package com.dsaninja.lc.tiq.easy.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target. You may assume that each input
 * would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <pre>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * </pre>
 *
 * <a href="https://leetcode.com/problems/two-sum/">Problem-1</a>
 */
public class TwoSum{
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> cache = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(cache.containsKey(target - nums[i])){
                return new int[]{cache.get(target - nums[i]), i};
            }
            cache.put(nums[i], i);
        }

        return null;
    }

    @Test
    @DisplayName("test two sum")
    public void testTwoSumV1(){
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    @DisplayName("test two sum with same elements")
    public void testTwoSumV2(){
        int[] result = twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(new int[]{0, 1}, result);
    }
}
