package com.qwei.solutions;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * 用一个stack存放数。每每见到一个运算符，就pop出两个数然后根据这个运算符进行运算。运算结果依然放回到stack。
 */
public class EvaluateReversePolishNotation {
  public static int evalRPN(String[] token) {
    if (token == null || token.length < 3) {
      return 0;
    }

    Stack<Integer> stack = new Stack<>();
    for (int i=0; i<token.length; i++) {
      String curr  = token[i];
      if (!isOperator(curr)) {
        int number = Integer.parseInt(curr);
        stack.push(number);
      } else {
        int value1 = stack.pop();
        int value2 = stack.pop();

        if (curr.equals("+")) {
          stack.push(value1 + value2);
        } else if (curr.equals("-")) {
          stack.push(value2 - value1);
        } else if (curr.equals("*")) {
          stack.push(value1 * value2);
        } else {
          stack.push(value2 / value1);
        }
      }
    }
    return stack.pop();
  }

  public static boolean isOperator(String s) {
    if (s == null || s.isEmpty()) {
      return false;
    }

    if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
      return true;
    }

    return false;
  }
}
