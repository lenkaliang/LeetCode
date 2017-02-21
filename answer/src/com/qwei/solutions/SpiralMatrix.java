package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral
 * order.
 *
 * https://leetcode.com/problems/spiral-matrix/?tab=Description
 */
public class SpiralMatrix {
  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();

    if (matrix == null || matrix.length == 0) {
      return list;
    }

    return helper(list, 0, 0, matrix.length, matrix[0].length, matrix);
  }

  public static List<Integer> helper(List<Integer> list, int x, int y, int m, int n, int[][] matrix) {
    if (m == 0 || n == 0) {
      return list;
    }

    if (m == 1) {
      for (int i = 0; i<n; i++) {
        list.add(matrix[x][y++]);
      }
      return list;
    }

    if (n == 1) {
      for (int i=0; i<m; i++) {
        list.add(matrix[x++][y]);
      }
      return list;
    }

    for (int i=0; i<n-1; i++) {
      list.add(matrix[x][y++]);
    }

    for (int i=0; i<m-1; i++) {
      list.add(matrix[x++][y]);
    }

    for (int i=0; i<n-1; i++) {
      list.add(matrix[x][y--]);
    }

    for (int i=0; i<m-1; i++) {
      list.add(matrix[x--][y]);
    }

    return helper(list, x+1, y+1, m-2, n-2, matrix);
  }
}
