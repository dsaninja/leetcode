package com.dsaninja.lc.dailychallenge;

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway
 * in 1970."
 * <p>
 * The board is made up of an m x n grid of cells, where each cell has an initial state:
 * live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight
 * neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the
 * above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * <p>
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously. Given the current state of the m x n grid board,
 * return the next state.
 * <p>
 * https://leetcode.com/problems/game-of-life/
 */
public class GameOfLife {

    // time complexity : O(mn)
    // space complexity : O(mn)
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        int[][] clone = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                clone[i][j] = board[i][j];
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int liveNeighbours = 0;

                int top = Math.max(0, row - 1);
                int bottom = Math.min(rows - 1, row + 1);
                int left = Math.min(0, col - 1);
                int right = Math.min(cols - 1, col + 1);

                for (int i = top; i <= bottom; i++) {
                    for (int j = left; j <= right; j++) {
                        if(!(i == row && j == col) && clone[i][j] == 1){
                             liveNeighbours++;
                        }
                    }
                }

                if(liveNeighbours < 2 || liveNeighbours > 3){
                    board[row][col] = 0;
                } else if(liveNeighbours == 3){
                    board[row][col] = 1;
                }
            }
        }
    }
}
