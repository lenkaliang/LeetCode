package com.qwei.solutions;

/**
 * https://leetcode.com/problems/island-perimeter/#/description
 *
 * 解法看这里：http://www.cnblogs.com/grandyang/p/6096138.html
 */
public class IslandPerimeter {
  public static int islandPerimeter(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int num = 0;
    for (int i=0; i<grid.length; i++) {
      for (int j=0; j<grid[0].length; j++) {

        if (grid[i][j] == 0) {
          continue;
        }

        num += 4;     // add up 4 sides of each cell
        if (i>0 && grid[i-1][j] == 1) {
          // neighboring up cell
          num -= 2;                   // deduct 2 becuase you added this side twice when add up all sides of each cell
                                      // now you want to remove 2 because this side is not a valid side.
        }

        if (j>0 && grid[i][j-1] == 1) {
          // neighboring left cell
          num -= 2;                   // same as above comment
        }
      }
    }
    return num;
  }
}
