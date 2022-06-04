package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array nums, return the third distinct maximum
 * number in this array. If the third maximum does not exist,
 * return the maximum number.
 *
 * <a href="https://leetcode.com/problems/third-maximum-number/">Problem-414</a>
 */
public class ThirdMaximum{

    /**
     * <ol>
     *  <li>Add elements in the set keeping its size 3; if size > 3. remove min value</li>
     *  <li>If set size is < 3; return max value</li>
     *  <li>else, return min value</li>
     * </ol>
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums){
        Set<Integer> max = new HashSet<>();

        for(int elem : nums){
            max.add(elem);

            // removing the min value always will ensure
            // that max 3 values in the current window are
            // present in the set
            if(max.size() > 3){
                max.remove(Collections.min(max));
            }
        }

        // from the max three values in set
        // if size < 3, return max value
        if(max.size() < 3){
            return Collections.max(max);
        }
        // otherwise return min value which will be
        // min of max 3 values i.e. 3rd max
        else{
            return Collections.min(max);
        }
    }

    @Test
    public void testThirdMax(){
        assertEquals(1, thirdMax(new int[]{3, 2, 1}));
        assertEquals(2, thirdMax(new int[]{1, 2}));
    }
}
