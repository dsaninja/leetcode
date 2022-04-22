package com.dsaninja.lc.tiq.easy.strings;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given two strings s and t, return true if t is an anagram of s,
 * and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different
 * word or phrase, typically using all the original letters exactly once.
 * <p>
 *
 * <a href="https://leetcode.com/problems/valid-anagram/">Problem-242</a>
 */
public class ValidAnagram{
    public boolean isAnagram(String s, String t) {
        // populate freq map as given lower case eng char only
        int[] freq = new int[26];
        for(char chr : s.toCharArray()){
            freq[Math.abs('a' - chr)]++;
        }

        for(char chr : t.toCharArray()){
            freq[Math.abs('a' - chr)]--;
        }

        // check if all elements are 0
        return IntStream.of(freq).noneMatch(val -> val != 0);
    }

    @Test
    public void testAnagramPositive(){
        assertTrue(isAnagram("anagram", "nagaram"));
    }

    @Test
    public void testAnagramNegative(){
        assertFalse(isAnagram("rat", "car"));
    }
}