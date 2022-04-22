package com.dsaninja.lc.tiq.easy.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * <a href="https://leetcode.com/problems/climbing-stairs/">Problem-70</a>
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;

        for (int i = 2; i <= n; i++) {
            steps[i] = steps[i-1] + steps[i - 2];
        }

        return steps[n];
    }

    @Test
    public void testSteps(){
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
        assertEquals(5, climbStairs(4));
    }
}
