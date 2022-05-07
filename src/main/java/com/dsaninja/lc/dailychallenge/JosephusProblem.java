package com.dsaninja.lc.dailychallenge;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.com/problems/find-the-winner-of-the-circular-game/">Problem-1823</a>
 */
public class JosephusProblem{

    // 1 <= k <= n <= 500
    public int josephus(int n, int k){
        if(n == 1) return 1;

        // with every iteration, n is decremented by 1
        // so f(n,k) can be represented as f(n-1, k) ...

        // After the k-th person is killed, a circle of n − 1 remains,
        // and the next count is started with the person whose number
        // in the original problem was ( k mod n ) + 1.
        // The position of the survivor in the remaining circle would be
        // f(n-1,k) if counting is started at 1;

        // shifting this to account for the fact that the starting point
        // is ( k mod n ) + 1 yields the recurrence:
        // f(n,k) = ((f(n-1,k)+k-1) mod n) + 1, with f(1,k)=1

        // which takes the simpler form
        // g(n,k) = ((g(n-1,k)+k) mod n), with g(1,k)=0
        // if the positions are numbered from 0 to n-1 instead.

        // read more: https://stackoverflow.com/a/31776222

        return ((josephus(n - 1, k) + k - 1) % n) + 1;
    }

    @Test
    public void testWinner(){
        // for k=2 and n = 2^m + l; f(n) = 2*l + 1
        // n = 16; f(n)=2*0 + 1 => 1
        assertEquals(1, josephus(16,2));
        // n = 17; f(n)=2*1 + 1 => 3
        assertEquals(3, josephus(17,2));
        // n = 41; f(n)=2*9 + 1 => 19
        assertEquals(19, josephus(41,2));
        
        
        assertEquals(1, josephus(6,5));
    }
}
