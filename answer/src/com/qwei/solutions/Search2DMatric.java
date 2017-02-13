package com.qwei.solutions;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the
 * following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * binary saerch
 */
public class Search2DMatric {
  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0) {
      return false;
    }

    int low = 0, high = matrix.length * matrix[0].length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      int x = mid/matrix[0].length, y = mid % matrix[0].length;    // see how y is calculated
      if (matrix[x][y] == target) {
        return true;
      } else if (matrix[x][y] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return false;
  }
}
