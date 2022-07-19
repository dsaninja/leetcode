package com.dsaninja.lc.recursionII;

import org.junit.jupiter.api.Test;

/**
 * SudoKu Solver
 *
 *  <a href="https://leetcode.com/problems/sudoku-solver/">Problem-37</a>
 */
public class SudokuSolver{

    @Test
    public void solveSudoKu(){
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }};

        if (solve(board)){
            print(board, board.length);
        }
    }

    public boolean solve(int[][] board){
        int row = -1;
        int col = -1;
        int n = board.length;

        boolean isCleaned = true;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;

                    isCleaned = false;
                    break;
                }
            }
            if(!isCleaned){
                break;
            }
        }

        if(isCleaned){
            return true;
        }

        for(int i = 0; i <= n; i++){
            if(isSafe(board, row, col, i)){
                board[row][col] = i;
                if(solve(board)){
                    return true;
                } else{
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }

    public static boolean isSafe(int[][] board,
                                 int row, int col,
                                 int num){
        // Check if the number we are trying to
        // place is already present in
        // that row, return false;
        for(int c = 0; c < board.length; c++){
            if(board[row][c] == num){
                return false;
            }
        }

        // Check if the number
        // we are trying to
        // place is already present in
        // that column, return false;
        for(int r = 0; r < board.length; r++){
            if(board[r][col] == num){
                return false;
            }
        }

        // Corresponding square has
        // unique number (box-clash)
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for(int r = boxRowStart; r < boxRowStart + sqrt; r++){
            for(int d = boxColStart; d < boxColStart + sqrt; d++){
                if(board[r][d] == num){
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;

    }

    public static void print(int[][] board, int N){

        // We got the answer, just print it
        for(int r = 0; r < N; r++){
            for(int d = 0; d < N; d++){
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
