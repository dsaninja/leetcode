package com.dsaninja.lc.dailychallenge;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * <pre>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * </pre>
 *
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">Problem-5</a>
 */
public class LongestPalindromicSubstring{
    public String longestPalindrome(String s) {
        int n = s.length(), start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];

        for (int len=0; len<n; len++) {
            for (int i=0; i+len<n; i++) {
                dp[i][i+len] = s.charAt(i) == s.charAt(i+len) && (len < 2 || dp[i+1][i+len-1]);
                if (dp[i][i+len] && len > end - start) {
                    start = i;
                    end = i + len;
                }
            }
        }
        return s.substring(start, end + 1);
    }
    
    @Test
    public void testLongestPalindrome(){
        assertEquals("bab", longestPalindrome("babad"));
    }
}
