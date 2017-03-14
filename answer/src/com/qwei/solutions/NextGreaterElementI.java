package com.qwei.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Description: https://leetcode.com/problems/next-greater-element-i/#/description
 *
 * Note: each element is unique
 * key: use a stack to create a map which contains all valid "number--next greater number" mappings
 */
public class NextGreaterElementI {
  public static int[] nextGreaterElement(int[] findNums, int[] nums) {
    if (findNums == null || nums == null || findNums.length == 0 || nums.length == 0) {
      return new int[0];
    }

    Stack<Integer> s = new Stack<>();
    Map<Integer, Integer> m = new HashMap<>();

    for (int n : nums) {
      while (!s.isEmpty() && s.peek() < n) {
        m.put(s.pop(), n);
      }
      s.push(n);
    }

    int[] ans = new int[findNums.length];
    for (int i=0; i<findNums.length; i++) {
      if (m.containsKey(findNums[i])) {
        ans[i] = m.get(findNums[i]);
      } else {
        ans[i] = -1;
      }
    }

    return ans;
  }
}
