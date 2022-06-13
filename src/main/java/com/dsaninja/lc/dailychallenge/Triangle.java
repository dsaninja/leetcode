package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below.
 * More formally, if you are on index i on the current row, you may move to
 * either index i or index i + 1 on the next row.
 *
 * <a href="https://leetcode.com/problems/triangle/">Problem-120</a>
 */
public class Triangle{
    // https://leetcode.com/problems/triangle/discuss/
    // 2144980/From-Memoization-to-DP-or-JAVA-Explanation
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];

        for (int level=n-1; level>=0; level--)
            for (int i=0; i<=level; i++)
                dp[level][i] = triangle.get(level).get(i) + Math.min(dp[level+1][i], dp[level+1][i+1]);

        return dp[0][0];
    }

    private int optionOne(List<List<Integer>>  ip){
        return ip.get(0).get(0) + Math.min(calculateMin(ip, 0, 1),calculateMin(ip, 1, 1));
    }

    private int calculateMin(List<List<Integer>> triangle, int prevIndex, int row){
        if(row < triangle.size()){
            // for every row
            // add current index and min of next
            // row
            return  triangle.get(row).get(prevIndex) +
                    Math.min(calculateMin(triangle, prevIndex, row + 1), calculateMin(triangle,prevIndex + 1, row + 1));
        }
        return 0;
    }
    
    @Test
    public void testMin(){
        List<List<Integer>> ip = new ArrayList<>();
        ip.add(List.of(1));
        ip.add(List.of(2, 3));
        ip.add(List.of(4, 5, 6));
        ip.add(List.of(7, 8, 9, 10));


        assertEquals(14, minimumTotal(ip));
        assertEquals(14, optionOne(ip));
    }
}
