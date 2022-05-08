package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3237/">EvenNumberOfDigits</a>
 */
public class EvenNumberOfDigits{
    public int findNumbers(int[] nums){
        return (int) Arrays.stream(nums).filter(ip -> ((int) Math.log10(ip) + 1) % 2 == 0).count();
    }
    
    @Test
    public void testEvenDigitCount(){
        assertEquals(2, findNumbers(new int[]{12,345,2,6,7896}));
    }
}
