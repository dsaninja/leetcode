package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given an array nums of n integers where nums[i] is
 * in the range [1, n], return an array of all the integers
 * in the range [1, n] that do not appear in nums.
 *
 * <pre>
 *     Input: nums = [4,3,2,7,8,2,3,1]
 *     Output: [5,6]
 * </pre>
 *
 * <a href="https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/">Problem-448</a>
 */
public class MissingNumbers{
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // as the given array is said to contain
        // elements from 1 to n, we can use the same
        // to our advantage

        // the idea is to negate values at index nums[i]
        // as nums[i] should be between 1 and n
        // will subtract 1 for 0 based index
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;

            // negate only if not seen previously
            if(nums[index] > 0){
                nums[index] = nums[index] * -1;
            }
        }

        // now any +ve value at index i means
        // that i+1 was never encountered as
        // otherwise it would have negated it
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }

        return result;
    }

    @Test
    public void testMissingNumber(){
        List<Integer> result = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        assertEquals(2, result.size());
        assertEquals(result, Arrays.asList(5, 6));
    }
}
