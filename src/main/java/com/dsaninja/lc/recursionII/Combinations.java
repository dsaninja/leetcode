package com.dsaninja.lc.recursionII;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * You may return the answer in any order.
 *
 * <pre>
 *     Input: n = 4, k = 2
 *     Output: [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * </pre>
 *
 * <a href="https://leetcode.com/problems/combinations/">Problem-77</a>
 */
public class Combinations{

    @Test
    public void testCombinations(){
        var result = combine(4,2);
        assertEquals(List.of(List.of(1,2), List.of(1,3), List.of(1,4), List.of(2,3), List.of(2,4), List.of(3,4)), result);
    }

    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> result = new ArrayList<>();
        combine(1, n, k, result, new ArrayList<>());
        return result;
    }

    private void combine(int start, int n, int k, List<List<Integer>> result, List<Integer> current){
        if(current.size() == k){
            result.add(new ArrayList<>(current));
        }

        for(int i = start; i <=n; i++){
            current.add(i);
            combine(i+1, n, k, result, current);
            current.remove(current.size()-1);
        }
    }
}
