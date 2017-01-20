package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent. A
 * mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * e.g. Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you
 * want.
 */
public class LetterCombinationsOfPhoneNumber {
  public static List<String> letterCombinations(String digits) {
    if (digits == null || digits.isEmpty()) {
      return new ArrayList<String>();
    }

    List<String> ret = new ArrayList<String>();
    StringBuilder builder = new StringBuilder();
    String[] pad = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    LetterCombinationsOfPhoneNumber.recursionHelper(ret, builder, 0, pad, digits);

    return ret;
  }

  // This problem can be much more straightforward if using recursion method
  private static void recursionHelper(List<String> ret, StringBuilder builder, int index, String[] pad, String digits) {
    if (index == digits.length()) {        // indicates you have done constructing digits.length()-1, which is the last character of the string
      ret.add(builder.toString());
      return;
    }

    char curr = digits.charAt(index);
    if (curr == '*' || curr == '#') {
      recursionHelper(ret, builder, index+1, pad, digits);
    } else {
      String string = pad[curr - '0'];
      for (int i=0; i<string.length(); i++) {
        builder.append(string.charAt(i));
        recursionHelper(ret, builder, index+1, pad, digits);
        builder.deleteCharAt(builder.length()-1);                 // Remember to delete the last char added in previous recursion
      }
    }
  }
}
