package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an array arr, replace every element in that array
 * with the greatest element among the elements to its right,
 * and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 * <a href="https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/">Problem-1299</a>
 */
public class ReplaceElements{
    public int[] replaceElements(int[] arr) {
        int length = arr.length;

        // let the last element be the amx element
        int maxSoFar = arr[length - 1];

        // set last element as -1
        arr[length - 1] = -1;

        // for n-2, n-3 ... 1, 0
        for(int i = arr.length - 2; i >= 0 ; i--){
            // if current element is more than maxSoFar, swap the two
            // as maxSoFar is still the highest element to its right
            // this way current element will be replaced with maxValue
            // to its right and maxSoFar will be updated for the elements
            // to the left of current element
            if(arr[i] > maxSoFar){
                int temp = maxSoFar;
                maxSoFar = arr[i];
                arr[i] = temp;
            }else{
                // otherwise simply replace current value
                // with max value to its right
                arr[i] = maxSoFar;
            }
        }

        return arr;
    }

    @Test
    public void  testReplaceElement(){
        assertArrayEquals(new int[]{18,6,6,6,1,-1}, replaceElements(new int[]{17,18,5,4,6,1}));
    }
}
