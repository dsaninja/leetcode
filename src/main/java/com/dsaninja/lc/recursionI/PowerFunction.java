package com.dsaninja.lc.recursionI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Implement pow(x, n), which calculates x raised to the power
 * n (i.e., xn).
 * 
 * <pre>
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 * 
 * </pre>
 *
 * <a href="https://leetcode.com/problems/powx-n/">Problem-50</a>
 */
public class PowerFunction{
    public double myPow(double x, int n) {
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        return calculate(x,n);
    }

    public double calculate(double x, int n) {
        if(n == 0){
            return 1;
        }

        double half = calculate(x, n / 2);
        if((n&1) == 0){
            return half * half;
        } else {
            return half * half * x;
        }
    }
    
    @Test
    public void testPower(){
        assertEquals(4, myPow(2,2));
        assertEquals(0.25, myPow(2,-2));
    }
}
