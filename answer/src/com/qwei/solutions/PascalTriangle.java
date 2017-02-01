package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {
  public static List<List<Integer>> generate(int numRows) {
    if (numRows <= 0) {
      return new ArrayList<List<Integer>>();
    }

    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    List<Integer> zero = new ArrayList<Integer>();
    zero.add(1);
    ret.add(zero);
    if (numRows == 1) {
      return ret;
    }

    List<Integer> one = new ArrayList<Integer>();
    one.add(1);
    one.add(1);
    ret.add(one);
    if (numRows == 2) {
      return ret;
    }

    for (int i = 2; i < numRows; i++) {
      List<Integer> pre = ret.get(i - 1);

      List<Integer> curr = new ArrayList<Integer>();
      curr.add(1);
      for (int j = 0; j < pre.size() - 1; j++) {
        curr.add(pre.get(j) + pre.get(j + 1));
      }
      curr.add(1);
      ret.add(curr);
    }

    return ret;
  }
}
