package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be
 * replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters. No two characters may map to
 * the same character, but a character may map to itself.
 *
 * <a href="https://leetcode.com/problems/isomorphic-strings/">Problem-205</a>
 */
public class IsomorphicStrings{
    public boolean isIsomorphic(String s, String t){
        if(s.length() == t.length()){
            Map<Character, Character> stoT = new HashMap<>();
            Map<Character, Character> ttoS = new HashMap<>();

            for(int i = 0; i < s.length(); i++){
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);

                if(stoT.containsKey(sChar) && stoT.get(sChar) != tChar){
                    return false;
                }

                else if(ttoS.containsKey(tChar) && ttoS.get(tChar) != sChar){
                    return false;
                }
                stoT.put(sChar, tChar);
                ttoS.put(tChar, sChar);
            }
        }

        return true;
    }

    @Test
    public void testIsomorphicStrings(){
        assertTrue(isIsomorphic("egg", "add"));
        assertTrue(isIsomorphic("paper", "title"));
        assertFalse(isIsomorphic("foo", "bar"));
        assertFalse(isIsomorphic("badc", "baba"));
    }
}
