package com.dsaninja.lc.tiq.easy.arrays;

/**
 * You are given an n x n 2D matrix representing an image,
 * rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to
 * modify the input 2D matrix directly. DO NOT allocate another
 * 2D matrix and do the rotation.
 *
 * <pre>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * 1 2 3            7 4 1
 * 4 5 6    =>      8 5 2
 * 7 8 9            9 6 3
 *
 * </pre>
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/
 */
public class RotateImage{

    /**
     * <ol>
     *     <li>row to col</li>
     *     <li>reverse</li>
     * </ol>
     *
     * @param matrix
     */
    public void rotate(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int[] ints : matrix){
            reverse(ints);
        }

    }

    private void reverse(int[] nums){
        int start = 0, end = nums.length - 1;
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
