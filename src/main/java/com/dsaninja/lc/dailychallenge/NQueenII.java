package com.dsaninja.lc.dailychallenge;

import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The n-queens puzzle is the problem of placing n queens on
 * an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions
 * to the n-queens puzzle.
 *
 * <a href="https://leetcode.com/problems/n-queens-ii/">Problem-52</a>
 */
public class NQueenII{
    public int totalNQueens(int n){
        int[][] board = new int[n][n];
        AtomicInteger result = new AtomicInteger();
        solve(board, 0, result);
        return result.get();
    }

    private void solve(int[][] board, int row, AtomicInteger result){
        if(row == board.length){
            result.getAndIncrement();
            return;
        }

        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 1;
                solve(board, row + 1, result);
                board[row][col] = 0;
            }
        }
    }

    private boolean isSafe(int[][] board, int row, int col){
        // row
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == 1){
                return false;
            }
        }

        // col
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == 1){
                return false;
            }
        }

        // upper left
        for(int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--){
            if(board[r][c] == 1){
                return false;
            }
        }

        // upper right
        for(int r = row - 1, c = col + 1; r >= 0 && c < board.length; r--, c++){
            if(board[r][c] == 1){
                return false;
            }
        }

        // bottom left
        for(int r = row + 1, c = col - 1; r < board.length && c >= 0; r++, c--){
            if(board[r][c] == 1){
                return false;
            }
        }

        // bottom right
        for(int r = row + 1, c = col + 1; r < board.length && c < board.length; r++, c++){
            if(board[r][c] == 1){
                return false;
            }
        }

        return true;
    }

    @Test
    public void testNQueen(){
        assertEquals(2, totalNQueens(4));
    }
}
