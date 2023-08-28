package com.dsaninja.lc.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an array nums with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 * <a href="https://leetcode.com/problems/sort-colors/description/">Problem-75</a>
 */
public class SortColors {

    @Test
    @DisplayName("")
    public void test(){
        assertArrayEquals(new int[]{0,0,1,1,2,2}, sortColors(new int[]{2,0,2,1,1,0}));
        assertArrayEquals(new int[]{0,1,2}, sortColors(new int[]{2,0,1}));

        assertArrayEquals(new int[]{0,0,1,1,2,2}, sortColorsV2(new int[]{2,0,2,1,1,0}));
        assertArrayEquals(new int[]{0,1,2}, sortColorsV2(new int[]{2,0,1}));
    }

    public int[] sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }else if(nums[mid] == 2){
                swap(nums, mid, high);
                mid++;
                high--;
            }else{
                mid++;
            }
        }

        return nums;
    }

    public int[] sortColorsV2(int[] nums) {
        int[] freq = new int[3];

        for(int num : nums){
            freq[num]++;
        }

        int index =0;
        while(freq[0]-- > 0){
            nums[index++] = 0;
        }

        while(freq[1]-- > 0){
            nums[index++] = 1;
        }

        while(freq[2]-- > 0){
            nums[index++] = 2;
        }

        return nums;
    }

    private void swap(int[] nums, int from, int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
