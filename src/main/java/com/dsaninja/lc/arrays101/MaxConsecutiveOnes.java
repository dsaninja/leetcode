package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a binary array nums, return the maximum number of
 * consecutive 1's in the array.
 *
 * <a href="https://leetcode.com/problems/max-consecutive-ones/">Problem-485</a>
 */
public class MaxConsecutiveOnes{
    public int findMaxConsecutiveOnes(int[] nums){
        int max = Integer.MIN_VALUE;
        int count = 0;

        for(int elem : nums){
            if(elem == 1){
                count++;
            } else{
                if(max < count){
                    max = count;
                }
                count = 0;
            }
        }
        
        // for the last batch of ones for which
        // the else never triggered
        if(count > max){
            max = count;
        }

        return max;
    }
    
    @Test
    public void testFindMaxConsecutiveOnes(){
        assertEquals(3, findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        assertEquals(1, findMaxConsecutiveOnes(new int[]{1,2,4}));
    }
}
