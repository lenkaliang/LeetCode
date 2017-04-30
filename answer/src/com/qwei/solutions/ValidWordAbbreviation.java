package com.qwei.solutions;

/**
 * Descciption goes here: https://leetcode.com/problems/valid-word-abbreviation/#/description
 *
 * 以下的实现方法简单易懂
 */
public class ValidWordAbbreviation {
  public boolean isValid(String word, String abbr) {
    int i=0, j=0;
    while (i < word.length() && j < abbr.length()) {
      if (word.charAt(i) == abbr.charAt(j)) {
        i++;
        j++;
        continue;
      }

      if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {  // corner case: "a" vs "01"
        return false;
      }

      int start = j;
      while (j<abbr.length() && abbr.charAt(j)>='0' && abbr.charAt(j)<='9') {
        j++;
      }
      int number = Integer.parseInt(abbr.substring(start, j));
      i += number;
    }

    return i == word.length() && j == abbr.length();        // corner case: "a" vs "2"
  }
}

