package com.qwei.solutions;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/?tab=Description
 *
 * From bottom to top calculation order
 */
public class Triangle {
  public static int minTotal(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    for (int i = triangle.size() - 2; i >= 0; i--) {
      List<Integer> current = triangle.get(i);
      List<Integer> next = triangle.get(i+1);

      for (int index = 0; index < current.size(); index++) {
        current.set(index, current.get(index) + Math.min(next.get(index), next.get(index + 1)));
      }
    }

    return triangle.get(0).get(0);
  }
}
