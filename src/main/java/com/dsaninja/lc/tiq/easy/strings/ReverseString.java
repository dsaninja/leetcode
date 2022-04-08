package com.dsaninja.lc.tiq.easy.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Write a function that reverses a string. The input string is given
 * as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * <pre>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * </pre>
 *
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 */
public class ReverseString{
    public void reverseString(char[] s){
        int start = 0, end = s.length - 1;
        while(start < end){
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }

    @Test
    @DisplayName("test reversing a string")
    public void testReverseString(){
        char[] ip = "dsaninja".toCharArray();
        reverseString(ip);

        assertArrayEquals(new StringBuilder("dsaninja").reverse().toString().toCharArray(), ip);
    }
}
