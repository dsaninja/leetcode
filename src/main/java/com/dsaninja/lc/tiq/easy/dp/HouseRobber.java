package com.dsaninja.lc.tiq.easy.dp;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security systems connected and it will automatically contact the police if
 * two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 * <a href="https://leetcode.com/problems/house-robber/">Problem-198</a>
 */
public class HouseRobber{
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int last = 0;
        int secondLast = nums[nums.length-1];

        for(int i = nums.length-2; i > 0; i--){
            int max = Math.max(secondLast, last + nums[i]);
            last = secondLast;
            secondLast = max;
        }

        return secondLast;
    }
}
