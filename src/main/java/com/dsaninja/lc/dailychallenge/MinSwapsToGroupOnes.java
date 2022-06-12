package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a binary array data, return the minimum number of
 * swaps required to group all 1’s present in the array together
 * in any place in the array.
 *
 * <a href="https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/">Problem-1151</a>
 */
public class MinSwapsToGroupOnes{
    // the minimum number of swaps will be for a window
    // having maximum number of 1s
    public int minSwaps(int[] data) {
        int start =0;
        int end = 0;

        int totalOnesInInput = Arrays.stream(data).filter(elem -> elem == 1).sum();

        int maxOnesInCurrent = 0;
        int maxOnesInAnyWindow = 0;

        // scan the input from index 0 to length
        // in a window of size range [0, totalOnesInInput]
        while(end < data.length){
            // include current element in window
            // and if 1, increase count of 1s in current window
            maxOnesInCurrent+= data[end++];

            // ensure that window size remains between
            // 0 and totalOnesInInput;
            if(end - start > totalOnesInInput){
                maxOnesInCurrent-= data[start++];
            }

            // update max 1s in any window considering
            // number of 1s in current window and any previous
            // count
            maxOnesInAnyWindow = Math.max(maxOnesInAnyWindow, maxOnesInCurrent);
        }

        return totalOnesInInput - maxOnesInAnyWindow;
    }

    @Test
    public void testMinSwaps(){
        assertEquals(1, minSwaps(new int[]{1,0,1,0,1}));
        assertEquals(3, minSwaps(new int[]{1,0,1,0,1,0,0,1,1,0,1}));
    }
}
