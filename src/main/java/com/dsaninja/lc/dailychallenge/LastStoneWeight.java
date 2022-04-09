package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * <p>
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and
 * smash them together. Suppose the heaviest two stones
 * have weights x and y with x <= y. The result of this smash is:
 * <p>
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 * <p>
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 * <p>
 * https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight{
    public int lastStoneWeight(int[] stones){
        if(stones.length == 1){
            return stones[0];
        }

        List<Integer> list = IntStream.of(stones).boxed().toList();
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.addAll(list);

        while(!queue.isEmpty()){
            int first = queue.poll();
            if(queue.isEmpty()){
                return first;
            }

            int second = queue.poll();
            int result = Math.abs(second - first);
            if(result != 0){
                queue.add(result);
            }
        }
        return 0;
    }

    @Test
    @DisplayName("test last stone weight")
    public void testLastStoneWeight(){
        int result = lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
        assertEquals(1, result);
    }
}
