package com.qwei.solutions;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * 以第一个String为参照物，维护一个longestCommonPrefix.
 */
public class LongestCommonPrefix {
  public static String longestCommonPrefix(String[] strs) {
    String longestCommonPrefix = "";
    if (strs == null || strs.length == 0) {
      return "";
    }

    int index = 0;
    String firstWord = strs[0];        // use the first word as comparing object

    while (index < firstWord.length()) {
      for (int i=1; i<strs.length; i++) {
        String word = strs[i];
        if (index >= word.length() || firstWord.charAt(index) != word.charAt(index)) {
          // When hitting a shorter string or the current char of word referenced by index does not equal the char from comparing object
          // return previously calculated longest common prefix
          return longestCommonPrefix;
        }
      }
      longestCommonPrefix += firstWord.charAt(index);     // if the current char pass the above check, go ahead and take the new to longest common prefix
      index++;
    }

    return longestCommonPrefix;
  }
}
