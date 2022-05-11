package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given an array of integers arr, return true if and only if
 * it is a valid mountain array.
 *
 * Recall that arr is a mountain array if and only if:
 * <pre>
 *     arr.length >= 3
 *     There exists some i with 0 < i < arr.length - 1 such that:
 *         arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *         arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * </pre>
 *
 * <a href="https://leetcode.com/problems/valid-mountain-array/">Problem-941</a>
 */
public class MountainArray{
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;

        int index = 0;
        int length = arr.length;

        // >> >> >>
        while(index + 1 < length && arr[index + 1] > arr[index]){
            index++;
        }

        // if first or last position return false
        // so it should be /\
        if(index == 0 || index == length - 1){
            return false;
        }

        while(index +1 < length && arr[index+1] < arr[index]){
            index++;
        }

        return index == length - 1;
    }

    @Test
    public void testValidMountain(){
        assertTrue(validMountainArray(new int[]{0, 3, 2, 1}));
    }
}
