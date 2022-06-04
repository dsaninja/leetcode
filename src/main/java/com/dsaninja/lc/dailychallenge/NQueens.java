package com.dsaninja.lc.dailychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The n-queens puzzle is the problem of placing n queens
 * on an n x n chessboard such that no two queens attack
 * each other.
 * <p>
 * Given an integer n, return all distinct solutions to
 * the n-queens puzzle. You may return the answer in any order.
 * <p>
 * Each solution contains a distinct board configuration
 * of the n-queens' placement, where 'Q' and '.' both
 * indicate a queen and an empty space, respectively.
 *
 * <pre>
 *     Input: n = 4
 *     Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * </pre>
 *
 *
 * <a href="https://www.youtube.com/watch?v=MHXR4PCY8c0">YouTube</a>
 *
 * <a href="https://leetcode.com/problems/n-queens/">Problem-51</a>
 */
public class NQueens{

    public List<List<String>> solveNQueens(int n){
        List<List<String>> allBoards = new ArrayList<>();
        nQueen(new int[n][n], 0, allBoards);

        return allBoards;
    }

    private void nQueen(int[][] matrix, int row, List<List<String>> allBoards){
        // if a queen is placed on all the rows?
        // add this matrix state to the allBoards list
        // as a valid state
        if(row == matrix.length){
            allBoards.add(Arrays.stream(matrix).map(mat -> Arrays.stream(mat).mapToObj(i-> i == 1? "Q" : ".").collect(Collectors.joining())).collect(Collectors.toList()));
            return;
        }

        // for the given row and all the columns
        for(int col = 0; col < matrix.length; col++){
            // if this row,col combination is valid
            if(isValid(matrix, row, col)){
                // put a queen at the current co-od
                matrix[row][col] = 1;
                // call the method for next row
                nQueen(matrix, row + 1, allBoards);

                // now reverse this placement so that
                // we can try all the next placements as well
                matrix[row][col] = 0;
            }
        }
    }


    // test all the options
    // horizontal, vertical and diagonal
    private boolean isValid(int[][] matrix, int row, int col){
        // horizontal
        for(int c = 0; c < matrix.length; c++){
            if(matrix[row][c] == 1){
                return false;
            }
        }

        // vertical
        for(int r = 0; r < matrix.length; r++){
            if(matrix[r][col] == 1){
                return false;
            }
        }

        // diagonal upper left
        for(int r = row-1, c=col-1; r >= 0 && c>= 0; r--, c--){
            if(matrix[r][c] == 1){
                return false;
            }
        }

        // diagonal lower right
        for(int r = row+1, c=col+1; r < matrix.length && c < matrix.length; r++, c++){
            if(matrix[r][c] == 1){
                return false;
            }
        }

        // diagonal upper right
        for(int r = row-1, c=col+1; r >=0 && c < matrix.length; r--, c++){
            if(matrix[r][c] == 1){
                return false;
            }
        }

        // diagonal lower left
        for(int r = row+1, c=col-1; r < matrix.length && c >= 0; r++, c--){
            if(matrix[r][c] == 1){
                return false;
            }
        }

        return true;
    }
}
