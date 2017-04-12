package com.qwei.solutions;

/**
 * Given an m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */
public class MinPathSum {
  public static int getMiniPath(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int m = grid.length, n = grid[0].length;
    int[][] table = new int[m][n];

    // initialize the table
    table[m-1][n-1] = grid[m-1][n-1];
    for (int i=m-2; i>=0; i--) {
      table[i][n-1] = grid[i][n-1] + table[i+1][n-1];
    }
    for (int j=n-2; j>=0; j--) {
      table[m-1][j] = grid[m-1][j] + table[m-1][j+1];
    }

    //dp --- it can only move to either down or right
    for (int i=m-2; i>=0; i--) {
      for (int j=n-2; j>=0; j--) {
        table[i][j] = grid[i][j] + Math.min(table[i+1][j], table[i][j+1]);
      }
    }

    return table[0][0];
  }
}
