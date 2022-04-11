package com.dsaninja.lc.dailychallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
 * <p>
 * In one shift operation:
 * <pre>
 *     Element at grid[i][j] moves to grid[i][j + 1].
 *     Element at grid[i][n - 1] moves to grid[i + 1][0].
 *     Element at grid[m - 1][n - 1] moves to grid[0][0].
 * </pre>
 * Return the 2D grid after applying shift operation k times.
 * <p>
 * https://leetcode.com/problems/shift-2d-grid/solution/
 */
public class Shift2dGrid{

    /**
     * The movement is a straightforward pattern. The value moves in "reading"
     * order, and then when it gets to the bottom right, it wraps around to
     * the top left.
     * <p>
     * <img src="../../../../../resources/images/com.dsaninja.lc.dailychallenge.Shift2dPattern.png" />
     * <p>
     * time: O(k.n.m); space: O(n.m)
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k){
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;


        for(; k > 0; k--){
            // capture bottom right element
            int previous = grid[rows][cols];

            for(int i = 0; i <= rows; i++){
                for(int j = 0; j <= cols; j++){
                    int temp = grid[i][j];
                    grid[i][j] = previous;
                    previous = temp;
                }
            }
        }


        List<List<Integer>> result = new ArrayList<>();
        for(int[] row : grid){
            List<Integer> listRow = new ArrayList<>();
            result.add(listRow);
            for(int v : row) listRow.add(v);
        }

        return result;
    }

    // time: O(n.m) space: O(n.m)
    public List<List<Integer>> shiftGridViaModulo(int[][] grid, int k) {

        int numCols = grid[0].length;
        int numRows = grid.length;

        // Setup the 2d list.
        List<List<Integer>> newGrid = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> newRow = new ArrayList<>();
            newGrid.add(newRow);
            for (int col = 0; col < numCols; col++) {
                newRow.add(0);
            }
        }

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int newCol = (col + k) % numCols;
                int wrapAroundCount = (col + k) / numCols;
                int newRow = (row + wrapAroundCount) % numRows;
                newGrid.get(newRow).set(newCol, grid[row][col]);
            }
        }

        return newGrid;
    }
}
