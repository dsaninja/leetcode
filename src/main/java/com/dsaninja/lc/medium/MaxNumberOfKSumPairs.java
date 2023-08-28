package com.dsaninja.lc.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given an integer array nums and an integer k.
 *
 * In one operation, you can pick two numbers from the array
 * whose sum equals k and remove them from the array.
 *
 * Return the maximum number of operations you can perform on the array.
 *
 * <a href="https://leetcode.com/problems/max-number-of-k-sum-pairs/">Problem-1679</a>
 */
public class MaxNumberOfKSumPairs {

    @Test
    public void test(){
        assertEquals(2, maxOperations(new int[]{1,2,3,4}, 5));
        assertEquals(1, maxOperations(new int[]{3,1,3,4,3}, 6));
        assertEquals(0, maxOperations(new int[]{3,1,5,1,1,1,1,1,2,2,3,2,2}, 1));
        assertEquals(4, maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3));

        assertEquals(2, maxOperationsV2(new int[]{1,2,3,4}, 5));
        assertEquals(1, maxOperationsV2(new int[]{3,1,3,4,3}, 6));
        assertEquals(0, maxOperationsV2(new int[]{3,1,5,1,1,1,1,1,2,2,3,2,2}, 1));
        assertEquals(4, maxOperationsV2(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2}, 3));
    }

    public int maxOperationsV2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for(int elem : nums) {
            int compliment = k - elem;
            if(freq.getOrDefault(compliment, 0) > 0){
                count++;
                freq.put(compliment, freq.get(compliment) - 1);
            }else{
                freq.put(elem, freq.getOrDefault(elem, 0) + 1);
            }
        }

        return count;
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        //O(n)
        for(int elem : nums){
            freq.put(elem, freq.getOrDefault(elem, 0) + 1);
        }

        int count = 0;
        for(int elem : nums){
            int difference = k-elem;
            // like k = 6 and elem = 3
            if(elem == difference){
                if(freq.containsKey(difference) && freq.get(difference) >=2) {
                    count++;
                    freq.put(elem, freq.get(elem) - 2);
                }
            }
            else if(freq.containsKey(difference) && freq.get(elem) != 0 && freq.get(difference) != 0){
                count++;
                freq.put(elem, freq.get(elem) - 1);
                freq.put(difference, freq.get(difference) - 1);
            }
        }

        return count;
    }
}
