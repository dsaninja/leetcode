package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given an array of words where each word consists
 * of lowercase English letters.
 *
 * wordA is a predecessor of wordB if and only if we can insert exactly
 * one letter anywhere in wordA without changing the order of the other
 * characters to make it equal to wordB.
 *
 * For example, "abc" is a predecessor of "abac", while "cba" is not a
 * predecessor of "bcad".
 *
 * A word chain is a sequence of words [word1, word2, ..., wordk]
 * with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of
 * word3, and so on. A single word is trivially a word chain with k == 1.
 *
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 *
 * <a href="https://leetcode.com/problems/longest-string-chain/">Problem-1048</a>
 */
public class LongestStringChain{
    public static int longestStrChain(String[] words){
        if(words == null || words.length == 0){
            return 0;
        }

        int res = 0;
        // Sort the given array on basis of length of words.
        // Such that for a word i we would be checking words having
        // length smaller than i
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word, 1);

            for(int i = 0; i < word.length(); i++){

                // generate all possible substrings
                // as max length anyway is given to be 16
                StringBuilder sb = new StringBuilder(word);
                String subStr = sb.deleteCharAt(i).toString();

                // if substr present and including it gives a longer chain
                if(map.containsKey(subStr) && map.get(subStr) + 1 > map.get(word)){
                    // increment the chain length by 1
                    // for the word from which substr was generated
                    map.put(word, map.get(subStr) + 1);
                }
            }

            // return the max chain length
            res = Math.max(res, map.get(word));
        }
        return res;
    }

    @Test
    public void testChain(){
        assertEquals(4, longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
}
