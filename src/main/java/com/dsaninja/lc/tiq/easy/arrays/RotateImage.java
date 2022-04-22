package com.dsaninja.lc.tiq.easy.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
 *
 * <a href="https://leetcode.com/problems/rotate-image/solution/">Problem-48</a>
 */
public class RotateImage{

    /**
     * The algorithm is based on following two steps:
     *
     * <ol>
     *     <li>Transpose: row to col</li>
     *     <li>reverse row wise</li>
     * </ol>
     *
     * @param matrix input matrix
     */
    public void rotate(int[][] matrix){
        transpose(matrix);
        reverse(matrix);

    }

    private void transpose(int[][] matrix){
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = i+1; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverse(int[][] matrix){
        for(int i = 0 ; i < matrix.length; i++){
            int start = 0; int end = matrix.length -1;

            while(start < end){
                int temp = matrix[i][start];
                matrix[i][start++] = matrix[i][end];
                matrix[i][end--] = temp;
            }
        }
    }

    @Test
    @DisplayName("test array rotation for 2D matrix")
    public void testRotation(){
        int[][] ip = new int[][]{{1,2,3}, {4,5,6},{7,8,9}};
        rotate(ip);

        assertArrayEquals(new int[][]{{7,4,1}, {8,5,2},{9,6,3}}, ip);
    }
}
