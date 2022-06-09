package com.dsaninja.lc.recursionI;

/**
 * Given an integer n, return the number of structurally unique BST's
 * (binary search trees) which has exactly n nodes of unique values from 1 to n.
 * <p>
 * 1 <= n <= 19
 *
 * <a href="https://leetcode.com/problems/unique-binary-search-trees/">Problem-96</a>
 */
public class UniqueBSTCount{
    int[] dp = new int[20];

    public int numTrees(int n){
        // Base case
        if(n <= 1){
            return 1;
        }

        // In case if the value is already present in the
        // array just return it and no need to calculate it
        if(dp[n] > 0){
            return dp[n];
        }

        // For all possible values of i, consider i as root,
        // then [1….i-1] numbers will fall in the left subtree and [i+1….n]
        // numbers will fall in the right subtree.
        // So, add (i-1)*(n-i) to the answer.
        for(int i = 1; i <= n; i++){
            dp[n] += numTrees(i - 1) * numTrees(n - i);
        }

        return dp[n];
    }
}
