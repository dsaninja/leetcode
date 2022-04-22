package com.dsaninja.lc.tiq.easy.strings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string s, find the first non-repeating character in it and
 * return its index. If it does not exist, return -1.
 *
 * Input: s = "leetcode"
 * Output: 0
 *
 * Input: s = "loveleetcode"
 * Output: 2
 *
 * <p>
 *
 * <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">Problem-387</a>
 */
public class FirstUniqueCharacter{
    public int firstUniqChar(String input) {

        // populate freq map as given lower case eng char only
        int[] freq = new int[26];
        for(char chr : input.toCharArray()){
            freq[Math.abs('a' - chr)]++;
        }

        // for all the input chars
        // check which has freq 1
        for(int i = 0 ; i < input.length() ; i++){
            if(freq[Math.abs('a' - input.charAt(i))] == 1){
                return i;
            }
        }

        return -1;
    }

    @Test
    public void testFirstUniqueCharacter(){
        assertEquals(0, firstUniqChar("leetcode"));
    }
}
