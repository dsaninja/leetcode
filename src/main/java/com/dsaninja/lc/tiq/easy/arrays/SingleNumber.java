package com.dsaninja.lc.tiq.easy.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one.
 * Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * <a href="https://leetcode.com/problems/single-number/">Problem-136</a>
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (left, right) -> left ^ right);
    }

    @Test
    public void testSingleNumber(){
        assertEquals(1, singleNumber(new int[]{2,2,1}));
        assertEquals(4, singleNumber(new int[]{4,1,2,1,2}));
        assertEquals(1, singleNumber(new int[]{1}));
    }
}
