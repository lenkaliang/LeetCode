package com.qwei.solutions;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Could you do this in-place?
 *
 * Trick of this problem: j moves faster than i, so
 * If the cursor moves along the vertical axis, make j show up in the row index
 * If the cursoe moves along the horizontal axis, make j show up in the column index
 *
 * Note: above condition is based on the assigner's (right part of "=") move
 */
public class RotateImage {
  public static void rotate(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }

    int len = matrix.length;
    for (int i=0; i<len/2; i++) {
      for (int j=i; j<len-i-1; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[len-j-1][i];    // moving from bottom to top in the left vertical axis
        matrix[len-j-1][i] = matrix[len-i-1][len-j-1];  // moving from right to left in the bottom horizontal axis
        matrix[len-i-1][len-j-1] = matrix[j][len-i-1];  // moving from top to bottom in the right vertical axis
        matrix[j][len-i-1] = temp;
      }
    }
  }
}
