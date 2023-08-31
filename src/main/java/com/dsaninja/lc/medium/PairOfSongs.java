package com.dsaninja.lc.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given a list of songs where the ith song
 * has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total
 * duration in seconds is divisible by 60. Formally, we want
 * the number of indices i, j such that
 * i < j with (time[i] + time[j]) % 60 == 0.
 *
 * <a href="https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/">Problem-1010</a>
 */
public class PairOfSongs {

    @Test
    public void test(){
        assertEquals(3, numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
        assertEquals(3, numPairsDivisibleBy60(new int[]{60,60,60}));
    }

    /**
     * <img alt="image desc" src="../../../../../resources/images/com.dsaninja.lc.medium.PairOfSongs.png" />
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
        int[]rem = new int[501];
        int count = 0;

        for(int duration : time){
            // if a%60==0 then
            // find the count of b such that
            // b%60 == 0 (as a can pair with any of those)
            if(duration % 60 == 0){
                count+=rem[0];
            }else{
                // otherwise, find the count of b
                // such that b%x == x-a%x
                count+=rem[60-(duration%60)];
            }

            rem[duration%60]++;
        }

        return count;
    }
}
