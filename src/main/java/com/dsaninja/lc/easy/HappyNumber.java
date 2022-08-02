package com.dsaninja.lc.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * <ol>
 *   <li>Starting with any positive integer, replace the number by the sum of the squares of its digits.</li>
 *   <li>Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.</li>
 *   <li>Those numbers for which this process ends in 1 are happy.</li>
 * </ol>
 *
 * <a href="https://leetcode.com/problems/happy-number/">Problem-202</a>
 */
public class HappyNumber{

    private final Set<Integer> cache = new HashSet<>();

    public boolean isHappy(int n) {
        if(n == 1){
            return true;
        }

        if(!cache.contains(n)){
            cache.add(n);

            int result = 0;
            while(n > 0){
                int rem = n % 10;
                result += rem*rem;
                n = n /10;
            }

            return isHappy(result);
        }

        return false;
    }

    @Test
    public void testIsHappy(){
        assertTrue(isHappy(19));
        assertFalse(isHappy(2));
        assertTrue(isHappy(1));
    }
}
