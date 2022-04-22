package com.dsaninja.lc.tiq.easy.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element
 * appears only once. The relative order of the elements should
 * be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some
 * languages, you must instead have the result be placed in the first
 * part of the array nums. More formally, if there are k elements after
 * removing the duplicates, then the first k elements of nums should hold
 * the final result It does not matter what you leave beyond the first k
 * elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 *
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Problem-26</a>
 */
public class RemoveDuplicates{

    public int removeDuplicates(int[] nums){
        // with this check the solution beats 100% of the java submissions
        if(nums.length == 1){
            return 1;
        }

        int lastUniqueNumber = Integer.MIN_VALUE;
        int slot = 0;
        for(int element : nums){
            if(element != lastUniqueNumber){
                lastUniqueNumber = element;
                nums[slot++] = element;
            }
        }

        // slot is expected to be 1 index based per question
        return slot;
    }

    public int removeDuplicatesV2(int[] nums){
        int slot = 0;
        for(int element : nums)
            if(slot == 0 || element > nums[slot - 1]){
                nums[slot++] = element;
            }
        return slot;
    }

    @Test
    @DisplayName("test removing duplicates when the array contains duplicate elements")
    public void testWithDuplicateElements(){
        int index = removeDuplicates(new int[]{1, 1, 2});
        assertEquals(2, index);
    }

    @Test
    @DisplayName("test removing duplicates when the array contains duplicate elements - v2")
    public void testWithDuplicateElementsV2(){
        int index = removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        assertEquals(5, index);
    }

    @Test
    @DisplayName("test removing duplicates when the array contains duplicate elements - v3")
    public void testWithDuplicateElementsV3(){
        int index = removeDuplicatesV2(new int[]{1, 1, 2});
        assertEquals(2, index);
    }

    @Test
    @DisplayName("test removing duplicates when the array contains duplicate elements - v4")
    public void testWithDuplicateElementsV4(){
        int index = removeDuplicatesV2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        assertEquals(5, index);
    }
}
