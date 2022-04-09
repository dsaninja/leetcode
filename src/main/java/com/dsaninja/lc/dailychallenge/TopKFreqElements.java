package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an integer array nums and an integer k, return the k most
 * frequent elements. You may return the answer in any order.
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Follow up: Your algorithm's time complexity must be better
 * than <code>O(n log n)</code>, where n is the array's size.
 */
public class TopKFreqElements{

    /**
     * Check {@link KthLargestElement} for details
     *
     * @param nums input array
     * @param k ith highest element
     * @return array of k most frequent elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        Queue<Map.Entry<Integer, Long>> minHeap = new PriorityQueue<>((e1, e2) -> Comparator.<Long>naturalOrder().compare(e1.getValue(), e2.getValue()));
        Map<Integer, Long> frequency = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(Map.Entry<Integer, Long> entry : frequency.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int [] result = new int[k];
        for(int i = 0; i < k; i++){
            // O(k log d) i.e. pop k elements out of d unique elements
            result[i] = Objects.requireNonNull(minHeap.poll()).getKey();
        }

        return result;
    }

    @Test
    @DisplayName("test top k elements")
    public void testTopKElements(){
        int[] ints = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        assertArrayEquals(new int[]{2,1}, ints);
    }
}
