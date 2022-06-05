package com.dsaninja.lc.recursion1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given n, calculate F(n).
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 *
 * <a href="https://leetcode.com/problems/fibonacci-number/">Problem-509</a>
 */
public class FibonacciNumber{
    Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int n){
        if(n < 2){
            return n;
        }

        if(cache.containsKey(n)){
            return cache.get(n);
        }

        int result = fib(n - 1) + fib(n - 2);
        cache.put(n, result);

        return result;
    }

    public int fibViaTabulation(int N) {
        if (N <= 1) {
            return N;
        }

        int[] cache = new int[N + 1];
        cache[1] = 1;
        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[N];
    }


    @Test
    public void testFib(){
        assertEquals(2,fib(3));
        assertEquals(3,fib(4));
    }
}
