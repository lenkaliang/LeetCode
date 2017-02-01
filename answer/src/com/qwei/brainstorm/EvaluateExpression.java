package com.qwei.brainstorm;

import java.util.Stack;

/**
 * Created by qwei1 on 1/30/17.
 * Evaluate algebra expression in Java.
 *
 * For this problem, the legal expression is assumed to pass in the function.
 *
 * There are a lot of corner cases, for the algorithm, please refer to this page:
 * <a>http://www.geeksforgeeks.org/expression-evaluation/</a>
 */
public class EvaluateExpression {
  public static void main(String[] args) {
    System.out.println(evaluate("100 * 5 + 5"));
    System.out.println(evaluate("5 + 100 * 5"));
    System.out.println(evaluate("(5 + 100) * 5"));

    System.out.println(evaluate("5 + (5 + 100 * 5)"));
  }

  public static int evaluate(String expression) {
    if (expression == null || expression.isEmpty()) {
      return -1;
    }

    Stack<Integer> values = new Stack<Integer>();
    Stack<Character> ops = new Stack<Character>();

    int i = 0;
    while (i<expression.length()) {
      char ch = expression.charAt(i);
      if (ch == ' ') {
        i++;
        continue;
      } else if (ch >= '0' && ch <= '9') {   // Processing this number
        StringBuffer buf = new StringBuffer();
        while (i<expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
          buf.append(expression.charAt(i++));
        }
        // get the complete number
        values.push(Integer.parseInt(buf.toString()));
        continue;
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {     // This if block is full of bugs
        if (!ops.isEmpty()) {
          char preOp = ops.peek();
          if (preOp == '(' || hasPrecedence(ch, preOp)) {
            ops.push(ch);
          }else {
            values.push(calculate(ops.pop(), values.pop(), values.pop()));
            ops.push(ch);
          }
        } else {
          ops.push(ch);
        }
      } else if (ch == '(') {
        ops.push(ch);
      } else {              // ch == ')'
        while (ops.peek() != '(') {
          values.push(calculate(ops.pop(), values.pop(), values.pop()));
        }
        ops.pop();          // get rid of '('
      }
      i++;
    }

    // Entire expression has been parsed at this point, apply remaining
    // ops to remaining values
    while (!ops.isEmpty()) {
      values.push(calculate(ops.pop(), values.pop(), values.pop()));
    }
    return values.pop();
  }

  public static boolean hasPrecedence(char op1, char op2) {
    if ((op1 == '*' || op1 == '/') && (op2 == '-' || op2 == '+')) {
      return true;
    }
    return false;
  }

  public static int calculate(char op, int b, int a) {
    switch (op) {
      case '+':
        return b + a;
      case '-':
        return a - b;
      case '*':
        return a * b;
      case '/':
        if (b == 0) {
          throw new UnsupportedOperationException("divider cannot be 0");
        }
        return a / b;
    }
    return 0;
  }
}
