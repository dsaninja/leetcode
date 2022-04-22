package com.dsaninja.lc.tiq.easy.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given an integer array prices where prices[i] is
 * the price of a given stock on the ith day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock. You can
 * only hold at most one share of the stock at any time. However,
 * you can buy it then immediately sell it on the same day.
 * <p>
 * Find and return the maximum profit you can achieve.
 * <pre>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * </pre>
 * <p>
 *
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">Problem-122</a>
 */
public class BestTimeToBuyAndSellStocks{
    public int maxProfit(int[] prices){
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]){
                profit = profit + (prices[i] - prices[i - 1]);
            }
        }

        return profit;
    }

    @Test
    @DisplayName("test best time to buy and sell")
    public void testMaxProfit(){
        int maxProfit = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assertEquals(7, maxProfit);
    }

    @Test
    @DisplayName("test best time to buy and sell - v2")
    public void testMaxProfitV2(){
        int maxProfit = maxProfit(new int[]{1, 2, 3, 4, 5});
        assertEquals(4, maxProfit);
    }

    @Test
    @DisplayName("test best time to buy and sell - v3")
    public void testMaxProfitV3(){
        int maxProfit = maxProfit(new int[]{7, 6, 4, 3, 1});
        assertEquals(0, maxProfit);
    }
}
