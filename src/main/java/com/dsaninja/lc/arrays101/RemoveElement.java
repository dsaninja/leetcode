package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array nums and an integer val, remove all
 * occurrences of val in nums in-place. The relative order of
 * the elements may be changed.
 *
 * <a href="https://leetcode.com/problems/remove-element/">Problem-27</a>
 */
public class RemoveElement{

    public int removeElementV2(int[] nums, int val) {

        int index = nums.length;
        for(int i = nums.length - 1; i >=0; i--){
            if(nums[i] == val){
                for(int j = i+1; j < nums.length; j++){
                    nums[j-1] = nums[j];
                }
                index--;
            }
        }

        return index;
    }

    public int removeElement(int[] nums, int val){
        if(nums.length == 0) return 0;

        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }

        return index;
    }
    
    @Test
    public void testElementRemove(){
        assertEquals(2, removeElementV2(new int[]{3,2,2,3}, 3));
    }
}
