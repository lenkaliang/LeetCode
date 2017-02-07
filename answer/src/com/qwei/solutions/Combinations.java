package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example, If n = 4 and k = 2, a solution is:
 *
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 */
public class Combinations {
  public static List<List<Integer>> getCombinations(int n, int k) {
    List<List<Integer>> list = new ArrayList<>();

    if (k == 1) {
      for (int i=1; i<=n; i++) {
        List<Integer> each = new ArrayList<>();
        each.add(i);
        list.add(each);
      }
      return list;
    }

    for (int i=n; i>=k; i--) {
      List<List<Integer>> temp = getCombinations(i-1, k-1);
      for (List<Integer> each : temp) {
        each.add(i);
        list.add(each);
      }
    }
    return list;
  }
}
