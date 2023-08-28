package com.dsaninja.lc.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given three integers a, b, and c, return the longest possible happy string.
 * If there are multiple longest happy strings, return any of them.
 * If there is no such string, return the empty string ""
 *
 * <a href="https://leetcode.com/problems/longest-happy-string/">Problem-1405</a>
 */
public class LongestHappyString {

    @Test
    public void test(){
        assertEquals("ccaccbcc", longestDiverseString(1,1,7));
        assertEquals("aabaa", longestDiverseString(7,1,0));
    }

    public String longestDiverseString(int a, int b, int c) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        int total = a + b + c;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < total; i++) {
            // if a is largest then use a
            // if a's count is not 2 or b or c is already on count 2
            if ((a >= b && a >= c && aCount < 2)
                    || (bCount == 2 && a > 0)
                    || (cCount == 2 && a > 0)) {
                sb.append("a");
                a--;
                aCount++;
                bCount = 0;
                cCount = 0;
            }

            // if b is largest then use b
            // if b's count is not 2 or a or c is already on count 2
            else if ((b >= a && b >= c && bCount < 2)
                    || (aCount == 2 && b > 0)
                    || (cCount == 2 && b > 0)) {
                sb.append("b");
                b--;
                bCount++;
                aCount = 0;
                cCount = 0;
            }

            // if c is largest then use c
            // if c's count is not 2 or a or b is already on count 2
            else if ((c >= a && c >= b && cCount < 2)
                    || (aCount == 2 && c > 0)
                    || (bCount == 2 && c > 0)) {
                sb.append("c");
                c--;
                cCount++;
                aCount = 0;
                bCount = 0;
            }
        }

        return sb.toString();
    }
}
