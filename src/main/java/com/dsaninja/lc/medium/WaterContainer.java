package com.dsaninja.lc.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * <a href="https://leetcode.com/problems/container-with-most-water/">Problem-11</a>
 */
public class WaterContainer {

    @Test
    @DisplayName("test max area")
    public void testMaxArea(){
        assertEquals(49, maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(1, maxArea(new int[]{1,1}));
    }


    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;

        int maxArea = Integer.MIN_VALUE;

        while(left < right){
            int min = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, min * (right-left));

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;

    }
}
