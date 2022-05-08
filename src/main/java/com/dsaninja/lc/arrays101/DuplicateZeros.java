package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given a fixed-length integer array arr,
 * duplicate each occurrence of zero, shifting
 * the remaining elements to the right.
 *
 * <a href="https://leetcode.com/problems/duplicate-zeros/">Problem-1089</a>
 */
public class DuplicateZeros{
    public void duplicateZeros(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                for(int j = arr.length-1; j > i; j--){
                    arr[j] = arr[j-1];
                }
                i++;
            }
        }
    }

    @Test
    public void testDuplicateZeros(){
        int[] ip = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(ip);
        assertArrayEquals(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, ip);
    }
}
