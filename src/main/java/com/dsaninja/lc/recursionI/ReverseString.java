package com.dsaninja.lc.recursionI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write a function that reverses a string. The input string is
 * given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * <a href="https://leetcode.com/problems/reverse-string/">Problem-344</a>
 */
public class ReverseString{
    public String reverseString(char[] s) {
        rev(s,0,s.length-1);
        return new String(s);
    }

    public void rev(char[] s, int left, int right){
        if(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            rev(s, left+1, right-1);
        }
    }

    @Test
    public void testReverse(){
        assertEquals("hello", reverseString("olleh".toCharArray()));
    }
}
