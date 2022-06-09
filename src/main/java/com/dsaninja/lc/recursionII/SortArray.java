package com.dsaninja.lc.recursionII;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an array of integers nums, sort the array in ascending order.
 *
 * <a href="https://leetcode.com/problems/sort-an-array/">Problem-912</a>
 */
public class SortArray{
    public int[] sortArray(int[] nums){
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] ip, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            sort(ip, start, mid);
            sort(ip, mid + 1, end);
            merge(ip, start, mid, end);
        }
    }

    private void merge(int[] ip, int start, int mid, int end){
        int[] result = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int index = 0;

        while(left <= mid && right <= end){
            if(ip[left] < ip[right]){
                result[index++] = ip[left++];
            } else{
                result[index++] = ip[right++];
            }
        }

        while(left <= mid){
            result[index++] = ip[left++];
        }

        while(right <= end){
            result[index++] = ip[right++];
        }

        System.arraycopy(result, 0, ip, start, result.length);
    }

    @Test
    public void test(){
        assertArrayEquals(new int[]{1,2,3,4,5}, sortArray(new int[]{4,2,5,1,3}));
        assertArrayEquals(new int[]{0,0,1,1,2,5}, sortArray(new int[]{5,1,1,2,0,0}));
        assertArrayEquals(new int[]{1,2,3,4,5}, sortArray(new int[]{5,4,3,2,1}));
    }

}
