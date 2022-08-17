package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * A strobogrammatic number is a number that looks the same
 * when rotated 180 degrees (looked at upside down).
 *
 * <a href="https://leetcode.com/problems/strobogrammatic-number/">Problem-246</a>
 */
public class StrobogrammaticNumber{

    // You might have observed a pattern in how digits move in the rotation:
    // the first and last swap,
    // the second and the second-to-last swap, etc.
    public boolean isStrobogrammatic(String num){
        Map<Character, Character> rotatedDigits = new HashMap<>(Map.of(
                '0', '0',
                '1', '1',
                '6', '9',
                '8', '8',
                '9', '6'));

        int left = 0;
        int right = num.length() - 1;

        while(left <= right){
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);

            if(!rotatedDigits.containsKey(leftChar) || rotatedDigits.get(leftChar) != rightChar){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    @Test
    public void testNum(){
        assertTrue(isStrobogrammatic("69"));
        assertTrue(isStrobogrammatic("88"));
        assertTrue(isStrobogrammatic("619"));
        assertFalse(isStrobogrammatic("62"));

    }
}
