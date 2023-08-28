package com.dsaninja.lc.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 *
 * <a href="https://leetcode.com/problems/number-of-islands/">Problem-200</a>
 */
public class NumberOfIslands {

    @Test
    @DisplayName("test number of islands")
    public void test() {
        assertEquals(1, numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));

        assertEquals(3, numIslands(new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }));
    }

    /**
     * Linear scan the 2d grid map, if a node contains a '1', then it is a root node
     * that triggers a Depth First Search. During DFS, every visited node should be
     * set as '0' to mark as visited node. Count the number of root nodes that trigger
     * DFS, this number would be the number of islands since each DFS starting at some
     * root identifies an island.
     *
     * @param grid to be processed
     * @return number of islands
     */
    public int numIslands(char[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        if (grid[row][col] == '1') {
            grid[row][col] = '0';
        }

        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row - 1, col);
        dfs(grid, row, col - 1);
    }
}
