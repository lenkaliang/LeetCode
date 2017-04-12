package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 *
 * For example, given n = 3, a solution set is: [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 *
 * 规则，如果做括号数量等于n。添加剩余的油括号。
 * 如果，左括号数量大于右括号数量，即可添加左括号，同时也可以添加右括号。
 * 如果，左括号数量等于右括号数量，只能添加左括号。
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
      return;
    }

    if (left > right) {
      recursiveHelper(ret, left + 1, right, tmp + "(", n);
      recursiveHelper(ret, left, right + 1, tmp + ")", n);
    }

    if (left == right) {
      recursiveHelper(ret, left + 1, right, tmp + "(", n);
    }
  }
}
