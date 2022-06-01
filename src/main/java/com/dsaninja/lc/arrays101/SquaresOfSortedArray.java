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

    public int[] sortedSquaresWithoutSorting(int[] input){
        int left = 0;
        int right = input.length - 1;
        int square;
        int[] result = new int[input.length];

        // assuming -ve values at the start of array
        // as its already sorted, lets use a 2 pointer
        // approach
        // whichever end has the largest abs value, that
        // will first go to the result
        // shift corresponding index
        for(int i = input.length - 1; i >= 0; i--){
            if(Math.abs(input[left]) > Math.abs(input[right])){
                square = input[left];
                left++;
            }else{
                square = input[right];
                right--;
            }

            result[i] = square * square;
        }

        return result;
    }

    @Test
    public void testSortedSquareArray(){
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquares(new int[]{-4, -1, 0, 3, 10}));
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquaresWithoutSorting(new int[]{-4, -1, 0, 3, 10}));
    }
}
