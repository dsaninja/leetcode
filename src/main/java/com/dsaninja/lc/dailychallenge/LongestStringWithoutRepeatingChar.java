package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string s, find the length of the longest substring
 * without repeating characters.
 *
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Problem-3</a>
 */
public class LongestStringWithoutRepeatingChar{
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end=0;
        int max=0;

        int[] freq = new int[128];

        while(end < s.length()){
            char c= s.charAt(end);
            freq[c]++;

            while(freq[c] > 1){
                char l = s.charAt(start);
                freq[l]--;
                start++;
            }

            max = Math.max(max, end-start+1);
            end++;
        }

        return max;
    }

    @Test
    public void testLength(){
        assertEquals(2, lengthOfLongestSubstring("abba"));
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }
}
