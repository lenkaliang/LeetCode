package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 *
 * For example, given n = 3, a solution set is: [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 *
 * Rule: if number of "(" is less than n, you can insert "("
 *       if number of "(" is bigger than the number of ")", you can either insert "(" or ")"
 *
 */
public class GenerateParentheses {
  public static List<String> generateParentheses(int n) {
    List<String> ret = new ArrayList<String>();
    if (n <= 0) {
      return ret;
    }

    GenerateParentheses.recursiveHelper(ret, 0, 0, "", n);
    return ret;
  }

  public static void recursiveHelper(List<String> ret, int left, int right, String tmp, int n) {
    if (left == n) { // left parentheses uses all n count
      for (int i = 0; i < n - right; i++) {
        tmp = tmp + ")";
      }
      ret.add(tmp);
    }

    if (left < n && left > right) {
      recursiveHelper(ret, left + 1, right, tmp + "(", n);
      recursiveHelper(ret, left, right + 1, tmp + ")", n);
    }

    if (left < n && left == right) {
      recursiveHelper(ret, left + 1, right, tmp + "(", n);
    }
  }
}
