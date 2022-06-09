package com.dsaninja.lc.recursionII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Write an efficient algorithm that searches for a value target in an m x n
 * integer matrix. This matrix has the following properties:
 *
 * <ol>
 * <li>Integers in each row are sorted in ascending from left to right.</li>
 * <li>Integers in each column are sorted in ascending from top to bottom.</li>
 * </ol>
 *
 * <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">Problem-240</a>
 */
public class Search2DArray{
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length -1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }

            else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }

        return false;
    }

    @Test
    public void testSearch(){
        assertTrue(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 9));
    }
        
}
