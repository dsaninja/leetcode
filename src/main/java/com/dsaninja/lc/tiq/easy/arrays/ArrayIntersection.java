package com.dsaninja.lc.tiq.easy.arrays;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must appear as many times as it
 * shows in both arrays and you may return the result in any order.
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * <p>
 *
 * <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/">Problem-350</a>
 */
public class ArrayIntersection{
    public int[] intersect(int[] nums1, int[] nums2){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Arrays.stream(nums1).forEach(elem -> frequencyMap.put(elem, frequencyMap.getOrDefault(elem, 0) + 1));

        Set<Integer> result = new HashSet<>();
        for(int elem : nums2){
            if(frequencyMap.getOrDefault(elem, 0) != 0){
                result.add(elem);
                frequencyMap.put(elem, frequencyMap.getOrDefault(elem, 1) - 1);
            }
        }

        return result.stream().mapToInt(value -> value).toArray();
    }

    @Test
    public void testIntersection(){
        int[] result = intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        assertArrayEquals(new int[]{4, 9}, result);
    }
}
