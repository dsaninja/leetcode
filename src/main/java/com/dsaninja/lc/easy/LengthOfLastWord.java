package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string s consisting of words and spaces,
 * return the length of the last word in the string.
 *
 * <a href="https://leetcode.com/problems/length-of-last-word/">Problem-58</a>
 */
public class LengthOfLastWord{
    public int lengthOfLastWord(String s) {
        int index = s.length()-1;
        int length = 0;

        while(index >= 0){
            if(s.charAt(index) != ' '){
                length++;
            }

            else if(length > 0){
                return length;
            }

            index--;
        }

        return length;
    }

    @Test
    public void testLength(){
        assertEquals(5, lengthOfLastWord("  hello    world   "));
        assertEquals(5, lengthOfLastWord("  hello    world"));
        assertEquals(5, lengthOfLastWord("  hello world"));
        assertEquals(5, lengthOfLastWord("  hello world  "));
    }
}
