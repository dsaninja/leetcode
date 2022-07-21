package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated,
 * and only the integer part of the result is returned.
 *
 * <a href="https://leetcode.com/problems/sqrtx/">Problem-69</a>
 */
public class SquareRoot{

    @Test
    public void testSqrt(){
        assertEquals(2, mySqrt(4));
        assertEquals(2, mySqrt(8));
        assertEquals(3, mySqrt(9));
        assertEquals(5, mySqrt(25));
        assertEquals(4, mySqrt(16));
        assertEquals(3, mySqrt(10));
        assertEquals(46340, mySqrt(2147483647));
        assertEquals(46339, mySqrt(2147395599));
    }

    public int mySqrt(int x){
        if(x < 2){
            return x;
        }


        // For x >= 2 the square root is always smaller than x/2 and
        // larger than 0: 0 < a < x/2.
        // Since a is an integer, the problem goes down to the iteration
        // over the sorted set of integer numbers.
        int start = 2, end = x / 2;

        while(start <= end){
            int mid = start + (end - start) / 2;
            long square = (long)mid * mid;

            if(square == x){
                return mid;
            }

            else if(square < x){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }

        return end;
    }
}
