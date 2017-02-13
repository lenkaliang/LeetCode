package com.qwei.solutions;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place
 *
 * Follow up: Did you use extra space? A straight forward solution using O(mn) space is probably a
 * bad idea. A simple improvement uses O(m + n) space, but still not the best solution. Could you
 * devise a constant space solution?
 */
public class SetMatrixZeroes {
  public static void setZeros(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    boolean[] row = new boolean[matrix.length];
    boolean[] col = new boolean[matrix[0].length];

    // initialize the boolean table
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          row[i] = true;
          col[j] = true;
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (row[i] || col[j]) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  /**
   * Explanation: http://fisherlei.blogspot.com/2013/01/leetcode-set-matrix-zeroes.html
   * Implementation: http://www.jiuzhang.com/solutions/set-matrix-zeroes/
   *
   */
  public static void setZerosConstantSpace(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    boolean rowZeroSet0 = false;
    boolean colZeroSet0 = false;
    for (int j = 0; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        rowZeroSet0 = true;
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        colZeroSet0 = true;
      }
    }

    for (int i=1; i<matrix.length; i++) {
      for (int j=1; j<matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for (int i=1; i<matrix.length; i++) {
      for (int j=1; j<matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // set first row / first column if needed
    if (rowZeroSet0) {
      for (int j=0; j<matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }
    if (colZeroSet0) {
      for (int i=0; i<matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}
