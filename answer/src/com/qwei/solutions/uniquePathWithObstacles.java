package com.qwei.solutions;

/**
 * Follow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * https://leetcode.com/problems/unique-paths-ii/?tab=Description
 */
public class uniquePathWithObstacles {
  public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null || obstacleGrid.length == 0) {
      return 0;
    }

    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    if (obstacleGrid[m - 1][n - 1] == 1) {
      return 0;
    } else {
      obstacleGrid[m - 1][n - 1] = 1;
    }

    for (int j = n - 2; j >= 0; j--) {
      if (obstacleGrid[m - 1][j] == 1) {
        for (int k = j; k >= 0; k--) {
          obstacleGrid[m - 1][k] = 0;
        }
        break;
      } else {
        obstacleGrid[m - 1][j] = 1;
      }
    }

    for (int i = m - 2; i >= 0; i--) {
      if (obstacleGrid[i][n - 1] == 1) {
        for (int k = i; k >= 0; k--) {
          obstacleGrid[k][n - 1] = 0;
        }
        break;
      } else {
        obstacleGrid[i][n - 1] = 1;
      }
    }

    for (int i = m - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {
        if (obstacleGrid[i][j] == 1) {
          obstacleGrid[i][j] = 0;
        } else {
          obstacleGrid[i][j] = obstacleGrid[i + 1][j] + obstacleGrid[i][j + 1];
        }
      }
    }

    return obstacleGrid[0][0];
  }
}
