package com.dsaninja.lc.tiq.easy.strings;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer
 * range [-231, 231 - 1], then return 0.
 *
 * <a href="https://leetcode.com/problems/reverse-integer/">Problem-7</a>
 */
public class ReverseInteger{
    public int reverse(int x) {
        int num1 = x, num2 = 0;
        while (num1 != 0) {
            if ((Integer.MAX_VALUE / 10) < num2 || (Integer.MIN_VALUE / 10) > num2) {
                return 0;
            }
            num2 = num2 * 10 + num1 % 10;
            num1 = num1 / 10;
        }
        return num2;
    }

    @Test
    @DisplayName("test reversing a number")
    public void testReverse(){
        int reverse = reverse(123);
        assertEquals(321, reverse);
    }
}
