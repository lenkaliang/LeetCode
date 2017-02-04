package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {
  public static List<Integer> getRow(int rowIndex) {
    List<Integer> row = new ArrayList<Integer>();
    row.add(1);
    if (rowIndex == 0) {
      return row;
    }

    row.add(1);
    if (rowIndex == 1) {
      return row;
    }

    for (int i=2; i<=rowIndex; i++) {
      List<Integer> list = new ArrayList<Integer>();
      list.add(1);
      for (int j=0; j<row.size()-1; j++) {
        list.add(row.get(j) + row.get(j+1));
      }
      list.add(1);
      row = list;
    }

    return row;
  }
}
