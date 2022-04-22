package com.dsaninja.lc.tiq.easy.dp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <h1>Problem-121</h1>
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Problem-121</a>
 */
public class MaxProfit {

    // time complexity : O(n^2)
    // space complexity : O(1)
    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;

        for (int buyDay = 0; buyDay < prices.length; buyDay++) {
            for (int sellDay = buyDay + 1; sellDay < prices.length; sellDay++) {
                if (prices[sellDay] - prices[buyDay] > maxProfit) {
                    maxProfit = prices[sellDay] - prices[buyDay];
                }
            }
        }

        return maxProfit;
    }

    // keep track of Best Buy day so far
    // keep track of the largest difference so far
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minSoFar = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minSoFar) {
                minSoFar = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minSoFar);
            }
        }

        return maxProfit;
    }

    @Test
    @DisplayName("test brute force solution")
    public void testProfitV1() {
        assertEquals(5, maxProfitBruteForce(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, maxProfitBruteForce(new int[]{7, 6, 4, 3, 1}));
        assertEquals(2, maxProfitBruteForce(new int[]{2, 4, 1}));
    }

    @Test
    @DisplayName("test one pass solution")
    public void testProfitV2() {
        assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
        assertEquals(2, maxProfit(new int[]{2, 4, 1}));
    }
}
