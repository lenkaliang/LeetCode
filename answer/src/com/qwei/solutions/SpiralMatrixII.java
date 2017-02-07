package com.qwei.solutions;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example, Given n = 3,
 *
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {
  public static int[][] generateMatrix(int n) {
    if (n == 0) {
      return new int[0][0];
    }
    int[][] ret = new int[n][n];
    fill(n, ret, 0, 0, 1);
    return ret;
  }

  public static void fill(int n, int[][] ret, int x, int y, int count) {
    if (n <= 0) {         // odd number will go below zero, even number will go equal zero
      return;
    }
    if (n == 1) {         // for odd number n
      ret[x][y] = count;
      return;
    }

    for (int i=0; i<n-1; i++) {     // i is used as a counter; setting upper row
      ret[x][y++] = count++;
    }
    for (int i=0; i<n-1; i++) {     // setting right column
      ret[x++][y] = count++;
    }
    for (int i=0; i<n-1; i++) {     // setting lower row
      ret[x][y--] = count++;
    }
    for (int i=0; i<n-1; i++) {     // setting left column
      ret[x--][y] = count++;
    }
    fill(n-2, ret, x+1, y+1, count); // count has been added 1 after last assignment
  }
}
