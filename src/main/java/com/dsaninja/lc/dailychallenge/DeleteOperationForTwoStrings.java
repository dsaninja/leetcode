package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given two strings word1 and word2, return the minimum number
 * of steps required to make word1 and word2 the same.
 * <p>
 * In one step, you can delete exactly one character in
 * either string.
 *
 * <a href="https://leetcode.com/problems/delete-operation-for-two-strings/">Problem-583</a>
 */
public class DeleteOperationForTwoStrings{

    // ============================ option 1 : timeout ======================

    /**
     * In order to determine the minimum number of delete operations needed,
     * we can make use of the length of the longest common sequence among the
     * two given strings s1 and s2, say given by lcs. If we can find this lcs
     * value, we can easily determine the required result as <code>m+n−2∗lcs</code>.
     * Here, m and n refer to the length of the two given strings s1 and s2.
     * <p>
     * The above equation works because in case of complete mismatch(i.e. if
     * the two strings can't be equalized at all), the total number of delete
     * operations required will be m+n . Now, if there is a common sequence among
     * the two strings of length lcs, we need to do lcs lesser deletions in both
     * the strings leading to a total of 2*lcs lesser deletions, which then leads to
     * the above equation.
     */
    public int minDistance(String word1, String word2){
        int m = word1.length();
        int n = word2.length();

        return m + n - 2 * calculate(word1, word2, m, n);
    }

    private int calculate(String word1, String word2, int m, int n){
        if(m == 0 || n == 0){
            return 0;
        }

        // If they match, we can consider the corresponding strings upto 1 lesser
        // lengths since the last characters have already been considered and
        // add 1 to the result to be returned for strings of 1 lesser lengths.
        if(word1.charAt(m - 1) == word2.charAt(n - 1)){
            return 1 + calculate(word1, word2, m - 1, n - 1);
        }

        // If the last characters don't match, we have two options,
        // either we can consider the second last character of s1
        // and the last character of s2, or we can consider the
        // second last character of s2 and the last character of s1.
        // We need to consider the larger result obtained out of the two
        // considerations for getting the required length.
        return Math.max(calculate(word1, word2, m - 1, n), calculate(word1, word2, m, n - 1));
    }


    // ============================ option 2 : memoization ======================
    public int minDistanceWithMemoization(String word1, String word2){
        int[][] memory = new int[word1.length() + 1][word2.length() + 2];
        int m = word1.length();
        int n = word2.length();

        return m + n - 2 * calculateWithMemoization(word1, word2, m, n, memory);
    }

    private int calculateWithMemoization(String word1, String word2, int m, int n, int[][] memory){
        if(m == 0 || n == 0){
            return 0;
        }

        if(memory[m][n] > 0){
            return memory[m][n];
        } else if(word1.charAt(m - 1) == word2.charAt(n - 1)){
            return 1 + calculateWithMemoization(word1, word2, m - 1, n - 1, memory);
        } else{
            memory[m][n] = Math.max(calculateWithMemoization(word1, word2, m, n - 1, memory), calculateWithMemoization(word1, word2, m - 1, n,
                    memory));
        }

        return memory[m][n];
    }

    // ======================= option 3 : DP ===========================

    /**
     * We make use of a 2-D dp, in which dp[i][j] represents the length of
     * the longest common subsequence among the strings s1 and s2 considering
     * their lengths upto (i−1) index and (j−1)th index only respectively.
     * <p>
     * In order to fill the entry for dp[i][j], we can have two cases:
     * <ol>
     *     <li>The characters s1[i−1] and s2[j−1] match with each other. In
     *     this case, the entry for dp[i][j] will be one more than the entry
     *     obtained for the strings considering their lengths upto one lesser
     *     index, since the matched character adds one to the length of LCS
     *     formed till the current indices. Thus, the dp[i][j] entry is updated
     *     as dp[i][j]=1+dp[i−1][j−1]. Note that dp[i−1][j−1] has been used
     *     because the matched character belongs to both s1 and s2.</li>
     *
     *     <li>The characters s1[i−1] and s2[j−1] don't match with each other.
     *     In this case, we can't increment the current entry as compared to
     *     entries corresponding to the previous indices, but we need to
     *     replicate the previous entry again to indicate that the length of
     *     LCS upto the current indices also remains the same. But, which
     *     entry to pick up? Now, since the current character hasn't matched,
     *     we have got two options. We can remove the current character from consideration
     *     from either s1s1s1 or s2s2s2 and use the corresponding dp entries given by
     *     dp[i−1][j] and dp[i][j−1] respectively. Since we are considering the length of
     *     LCS upto the current indices we need to pick up the larger entry out
     *     of these two to update the current dp entry.-</li>
     * </ol>
     * <p>
     * At the end, again, we obtain the number of deletions required as m+n−2∗dp[m][n],
     * where mmm and nnn refer to the lengths of s1 and s2. dp[m][n]
     * now refers to the length of LCS among the two given strings.
     */
    public int minDistanceDP(String s1, String s2){
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                if(i == 0 || j == 0){
                    continue;
                }
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                     // we need to replicate the previous entry again to
                    // indicate that the length of
                    // LCS upto the current indices also remains the same
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return s1.length() + s2.length() - 2 * dp[s1.length()][s2.length()];
    }

    // ========================= option 4 : DP v2 ==============================

    /**
     * Instead of finding the length of LCS and then determining
     * the number of deletions required, we can make use of Dynamic Programming
     * to directly determine the number of deletions required till the current
     * indices of the strings.
     *
     */
    public int minDistanceDPv2(String s1, String s2) {
        // dp[i][j] refers to the number of deletions required to equalize
        // the two strings if we consider the strings' length upto (i−1) and
        // (j−1) index for s1 and s2 respectively.
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = i + j;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    // The characters s1[i−1] and s2[j−1] match with each other.
                    // In this case, we need to replicate the entry corresponding
                    // to dp[i−1][j−1] itself. This is because, the matched character
                    // doesn't need to be deleted from any of the strings.
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    // don't match with each other. In this case, we need to delete
                    // either the current character of s1 or s2
                    // Thus, an increment of 1 needs to be done relative to the entries
                    // corresponding to the previous indices.
                    // Since, we are keeping track of the minimum number of deletions required,
                    // we pick up the minimum out of these two values.
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    @Test
    public void testMinDistance(){
        assertEquals(2, minDistance("manu", "sanu"));
        assertEquals(2, minDistanceWithMemoization("manu", "sanu"));
        assertEquals(2, minDistanceDP("manu", "sanu"));
    }
}
