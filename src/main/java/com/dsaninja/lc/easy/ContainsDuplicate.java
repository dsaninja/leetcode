package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given an integer array nums and an integer k, return true
 * if there are two distinct indices i and j in the array such
 * that nums[i] == nums[j] and abs(i - j) <= k.
 *
 * <a href="https://leetcode.com/problems/contains-duplicate-ii/">Problem-219</a>
 */
public class ContainsDuplicate{
    public boolean containsNearbyDuplicate(int[] nums, int k){
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(freq.containsKey(nums[i]) && Math.abs(i - freq.get(nums[i])) <= k){
                return true;
            }

            freq.put(nums[i], i);
        }

        return false;
    }

    @Test
    public void testNearByDuplicates(){
        assertTrue(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        assertTrue(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        assertFalse(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
