package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given a sorted unique integer array nums.
 * <p>
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * Return the smallest sorted list of ranges that cover all the numbers
 * in the array exactly. That is, each element of nums is covered by exactly
 * one of the ranges, and there is no integer x such that x is in one
 * of the ranges but not in nums.
 *
 * <a href="https://leetcode.com/problems/summary-ranges/">Problem-228</a>
 */
public class SummaryRanges{

    public List<String> summaryRanges(int[] nums){
        List<String> result = new ArrayList<>();

        if(nums.length > 0){
            int next = nums[0];
            int start = next;

            for(int i = 1; i < nums.length; i++){
                if(next + 1 == nums[i]){
                    next++;
                } else{
                    prep(result, start, next);
                    start = nums[i];
                    next = nums[i];
                }
            }

            prep(result, start, next);
        }

        return result;
    }

    private void prep(List<String> result, int lower, int upper){
        if(lower == upper){
            result.add(String.valueOf(lower));
        } else{
            result.add(lower + "->" + upper);
        }
    }

    @Test
    public void testSummary(){
        assertEquals(List.of("0->2", "4->5", "7"), summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        assertEquals(List.of("0", "2->4", "6", "8->9"), summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}
