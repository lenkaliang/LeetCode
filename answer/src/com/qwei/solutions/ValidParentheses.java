package com.qwei.solutions;

import com.sun.tools.classfile.CharacterRangeTable_attribute;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]"
 * are not.
 *
 * Note this string only contains the parentheses
 */
public class ValidParentheses {
  public static boolean isValid(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }

    boolean isValid = true;
    Map<Character, Character> lookupTable = new HashMap<Character, Character>();
    lookupTable.put('(', ')');
    lookupTable.put('{', '}');
    lookupTable.put('[', ']');

    Stack<Character> stack = new Stack<Character>();
    for (int i=0; i<s.length(); i++) {
      char currChar = s.charAt(i);
      if (lookupTable.containsKey(currChar)) {    // left parethese
        stack.push(currChar);
      } else {                                    // right parenthese
        if (stack.isEmpty()) {
          isValid = false;
        } else {
          char rightRight = lookupTable.get(stack.pop());
          if (rightRight != currChar) {
            isValid = false;
          }
        }
      }
    }
    if (!stack.isEmpty()) {
      isValid = false;
    }
    return isValid;
  }
}
