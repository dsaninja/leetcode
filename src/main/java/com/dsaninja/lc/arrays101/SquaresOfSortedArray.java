package com.dsaninja.lc.arrays101;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an integer array nums sorted in non-decreasing order, return an
 * array of the squares of each number sorted in non-decreasing order.
 *
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">Problem-977</a>
 */
public class SquaresOfSortedArray{
    public int[] sortedSquares(int[] nums){
        return Arrays.stream(nums).map(ip -> ip * ip).sorted().toArray();
    }

    @Test
    public void testSortedSquareArray(){
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquares(new int[]{-4, -1, 0, 3, 10}));
    }
}
