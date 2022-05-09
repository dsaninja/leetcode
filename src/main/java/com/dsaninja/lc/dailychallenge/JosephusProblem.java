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
        // and the person who was originally at k+1 position
        // is now at kth position to start the next iteration

        // hence the recurrence rel can be defined as:
        // f(n,k) = f(n-1,k) + k

        // for a zero index based array, kth person is actually
        // at k-1 index, so re-writing it for 0 based index:
        // f(n,k) = f(n-1,k) + k -1

        // but here is a problem, with n decreasing by 1 in
        // every iteration and k (or k-1) remaining same,
        // after some number of iterations, k will be more than
        // n and hence when finding kth person in n size array,
        // we may go out of bound; to solve this lets re-write it
        // using mod
        // f(n,k) = (f(n-1,k) + k -1) mod n

        // now this will give us a solution for 0 index based
        // array; to match it again with 1 based numbers in input
        // let's add 1
        // f(n,k) = ((f(n-1,k) + k -1) mod n) + 1

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
