package com.dsaninja.lc.tiq.easy.design;

import java.util.Arrays;
import java.util.Random;

/**
 * Given an integer array nums, design an algorithm to randomly
 * shuffle the array. All permutations of the array should be
 * equally likely as a result of the shuffling.
 *
 * <a href="https://leetcode.com/problems/shuffle-an-array/">Problem-384</a>
 */
public class ShuffleArray{
    private final int[] nums;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] copy = Arrays.copyOf(nums, nums.length);
        for(int i = 0; i < nums.length; i++){
            int someIndex = new Random().nextInt(i, nums.length);
            int temp = copy[i];
            copy[i] = copy[someIndex];
            copy[someIndex] = temp;
        }

        return copy;
    }
}
