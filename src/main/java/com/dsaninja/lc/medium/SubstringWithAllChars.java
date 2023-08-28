package com.dsaninja.lc.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string s consisting only of characters a, b and c.
 *
 * Return the number of substrings containing at least one
 * occurrence of all these characters a, b and c.
 *
 * <a href="https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/">Problem-1358</a>
 */
public class SubstringWithAllChars {

    @Test
    public void testNumber(){
        assertEquals(10, numberOfSubstrings("abcabc"));
        assertEquals(3, numberOfSubstrings("aaacb"));
        assertEquals(1, numberOfSubstrings("abc"));
    }

    public int numberOfSubstrings(String s) {
        int[] track = new int[3]; //also we can use 3 variables for counting (a, b, c)
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            track[s.charAt(i) - 'a']++;

            while (track[0] > 0 && track[1] > 0 && track[2] > 0) {
                // if a substring x has at least one a, one b, and one c,
                // then every possible longer substring with x as the start
                // also has at least one a, one b, and one c.
                // ex: for this "abcxyz" and i=2, 4 substring exist
                // abc, abcx, abxy, abcxyz (6-2 = 4)
                res += s.length() - i;
                track[s.charAt(left++) - 'a']--;
            }
        }
        return res;
    }
}
