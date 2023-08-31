package com.dsaninja.lc.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/problems/maximum-subsequence-score/">Problem-2542</a>
 */
public class MaximumSubsequenceScore {

    @Test
    @DisplayName("test max score")
    public void test(){
        assertEquals(12, maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3));
        assertEquals(30 , maxScore(new int[]{4,2,3,1,1}, new int[]{7,5,10,9,6}, 1));
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pairs = new int[nums1.length][2];

        for(int i=0; i < nums1.length; i++){
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }

        // decreasing order based on second array elements
        Arrays.sort(pairs, (pairOne, pairTwo) -> pairTwo[1]-pairOne[1]);

        long maxScore = 0;

        // min Heap
        Queue<Integer> pq = new PriorityQueue<>(k, (a,b) -> a - b);

        // add first k elements to the queue
        for (int i = 0; i < k; i++) {
            pq.add(pairs[i][0]);
            maxScore += pairs[i][0];
        }

        // The score of the first k pairs.
        long answer = maxScore * pairs[k - 1][1];

        for (int i = k; i < nums1.length; i++) {
            // Remove the smallest integer from the previous top k elements
            // then add nums1[i] to the top k elements.
            maxScore += pairs[i][0] - pq.poll();
            pq.add(pairs[i][0]);

            // Update answer as the maximum score.
            answer = Math.max(answer, maxScore * pairs[i][1]);
        }

        return answer;
    }
}
