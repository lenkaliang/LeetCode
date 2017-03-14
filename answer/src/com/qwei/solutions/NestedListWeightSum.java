package com.qwei.solutions;

import com.qwei.utils.NestedInteger;

import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their
 * depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other
 * lists.
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 */
public class NestedListWeightSum {
  public static int depthSum(List<NestedInteger> nestedList) {
    int sum = 0;
    if (nestedList == null || nestedList.size() == 0) {
      return sum;
    }

    for (NestedInteger ni: nestedList) {
      sum = getSum(ni, sum, 1);
    }

    return sum;
  }

  public static int getSum(NestedInteger n, int sum, int depth) {
    if (n == null) {
      return sum;
    }

    if (n.isInteger()) {
      return sum + n.getInteger() * depth;
    }

    // if n is not an integer, it must be a list of integer or list of list or list of integer + list
    List<NestedInteger> list = n.getList();
    for (NestedInteger m: list) {
      sum = getSum(m, sum, depth);
    }
    return sum;
  }
}
