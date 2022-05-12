package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array nums, move all the even integers at
 * the beginning of the array followed by all the odd integers.
 *
 * Return any array that satisfies this condition.
 *
 * <a href="https://leetcode.com/problems/sort-array-by-parity/">Problem-905</a>
 */
public class SortByParity{
    public int[] sortArrayByParity(int[] nums) {
        int index =0;
        for(int i = 0 ; i < nums.length ; i++){
            if((nums[i] & 1) == 0){
                int temp = nums[index];
                nums[index++] = nums[i];
                nums[i] = temp;
            }
        }

        return nums;
    }

    @Test
    public void testSorting(){
        assertArrayEquals(new int[]{2,4,3,1}, sortArrayByParity(new int[]{3,1,2,4}));
    }
}
