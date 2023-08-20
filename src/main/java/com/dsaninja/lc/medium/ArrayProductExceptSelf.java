package com.dsaninja.lc.medium;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * <a href="https://leetcode.com/problems/product-of-array-except-self/description/">Problem-238</a>
 */
public class ArrayProductExceptSelf {

    @Test
    @DisplayName("test productExceptSelf left, right approach")
    public void productExceptSelfV1(){
        assertArrayEquals(new int[]{24,12,8,6}, productExceptSelfV1(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{0,0,9,0,0}, productExceptSelfV1(new int[]{-1,1,0,-3,3}));
    }

    @Test
    @DisplayName("test productExceptSelf using single array approach")
    public void productExceptSelfV2(){
        assertArrayEquals(new int[]{24,12,8,6}, productExceptSelfV2(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{0,0,9,0,0}, productExceptSelfV2(new int[]{-1,1,0,-3,3}));
    }

    public int[] productExceptSelfV1(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0]=1;
        for(int i=1; i < nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length-1] = 1;
        for(int i= nums.length-2; i >= 0; i--){
            right[i] = right[i+1]*nums[i+1];
        }

        for(int i=0; i < nums.length; i++){
            result[i] = left[i]* right[i];
        }

        return result;
    }


    public int[] productExceptSelfV2(int[] nums) {
        int[] result = new int[nums.length];

        result[0]=1;
        for (int i = 1; i < nums.length; i++) {
            result[i]=result[i-1]*nums[i-1];
        }

        int rightProduct = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            result[i]=rightProduct* result[i];
            rightProduct = rightProduct*nums[i];
        }


        return result;
    }
}
