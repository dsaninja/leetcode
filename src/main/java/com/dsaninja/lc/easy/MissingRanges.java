package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given an inclusive range [lower, upper] and a
 * sorted unique integer array nums, where all elements are
 * in the inclusive range.
 *
 * A number x is considered missing if x is in the range [lower, upper]
 * and x is not in nums.
 *
 * Return the smallest sorted list of ranges that cover every missing
 * number exactly. That is, no element of nums is in any of the ranges, and each
 * missing number is in one of the ranges.
 *
 * <a href="https://leetcode.com/problems/missing-ranges/">Problem-163</a>
 */
public class MissingRanges{

    // next element is lower than nums[i]
    // next element == nums[i]
    // next element > nums[i] and i == nums.length
    public List<String> findMissingRanges(int[] nums, int lower, int upper){

        List<String> result = new ArrayList<>();

        // edge case, no element in array
        if(nums.length == 0){
            prep(result, lower, upper);
        }

        int next = lower;

        for(int i = 0; i < nums.length; i++){
            // next element is lower than nums[i]
            if(next < nums[i]){
                prep(result, next, nums[i]-1);
                next = nums[i];
            }

            // next element == nums[i]
            if(next == nums[i]){
                next++;
            }

            // last array element < upper
            if(i == nums.length -1 && nums[i] < upper){
                prep(result, next, upper);
            }
        }

        return result;
    }

    private void prep(List<String> result, int lower, int upper){
        if(lower == upper){
            result.add(String.valueOf(lower));
        }else{
            result.add(lower + "->" + upper);
        }
    }

    @Test
    public void testRange(){
        System.out.println(findMissingRanges(new int[]{0,1,3,50,75}, 0, 99));
    }
}
