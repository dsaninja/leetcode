package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given an array of positive integers nums and want to
 * erase a subarray containing unique elements. The score you get
 * by erasing the subarray is equal to the sum of its elements.
 * <p>
 * Return the maximum score you can get by erasing exactly
 * one subarray.
 * <p>
 * An array b is called to be a subarray of a if it forms a contiguous
 * subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some
 * (l,r).
 *
 * <a href="https://leetcode.com/problems/maximum-erasure-value/">Problem-1695</a>
 */
public class MaximumErasureValue{

    public int max(int[] nums){
        Map<Integer, Integer> freq = new HashMap<>();
        int[] prefixSum = new int[nums.length + 1];

        int start = 0;
        int max = Integer.MIN_VALUE;


        // populate freq map with element and its
        // index.
        for(int end = 0; end < nums.length; end++){
            prefixSum[end + 1] = prefixSum[end] + nums[end];
            // We have to check if the current subarray starting at index start and
            // ending at index end has all unique elements. We already have a
            // map that maintains the last indexes of all elements in the subarray.
            // Can we reuse the same map?

            // We could use this map to know the last index of currentElement.
            // If the last occurrence of currentElement is between the start and end
            // pointer, its last index would be greater than the start index. We can
            // use this trick to determine if the currentElement is unique in
            // the current subarray or not.
            //
            // If the last index of current element is greater than start,
            // then update start to the position after last index of currentElement:
            // start = max(start, lastIndexMap.get(currentElement) + 1)
            if(freq.containsKey(nums[end])){
                start = Math.max(start, freq.get(nums[end]) + 1);
            }

            // populate the freq and calculate max value
            freq.put(nums[end], end);

            max = Math.max(max, prefixSum[end + 1] - prefixSum[start]);

        }

        return max;
    }

    @Test
    public void testMax(){
        // The optimal subarray here is [2,4,5,6]
        assertEquals(17, max(new int[]{4,2,4,5,6}));
    }


    // We would iterate over each array element at most twice.
    // First, to add it to the current subarray using the end pointer.
    // Second, to remove it from the subarray using the start pointer.
    // This gives us time complexity as O(2n) which is
    // roughly O(n)
    // now to calculate the sum an additional loop is required which will
    // increase the complexity to O(n^2)
    // to reduce this, use prefix sum array
    public int maximumUniqueSubarray(int[] nums){
        int[] freq = new int[10001];
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;

        // start from index 0 to length of array
        while(end < nums.length){
            // increment freq of current element
            int currElement = nums[end];
            freq[currElement]++;

            // when we find that the newly added element is not unique in the
            // current subarray, we remove the elements from the beginning of the
            // subarray one-by-one incrementing the start pointer by 1 and
            // shrink the subarray until it contains all the unique elements.
            while(start <= end && freq[currElement] > 1){
                int prevElement = nums[start];
                freq[prevElement]--;
                start++;
            }

            // now the remaining window has
            // all unique characters
            int sum = 0;
            for(int i = start; i <= end; i++){
                sum += nums[i];
            }

            // check if the current unique element
            // sum is max
            max = Math.max(max, sum);

            // expand window by including next element
            end++;
        }

        // return max
        return max;
    }

    @Test
    public void testMaximumUniqueSubarray(){
        // The optimal subarray here is [2,4,5,6]
        assertEquals(17, maximumUniqueSubarray(new int[]{4,2,4,5,6}));
    }

}
