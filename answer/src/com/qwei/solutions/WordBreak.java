package com.qwei.solutions;

import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * 很好的讲解：http://bangbingsyb.blogspot.com/2014/11/leetcode-word-break-i-ii.html
 */
public class WordBreak {
  public static boolean wordBreak(String s, List<String> dict) {
    if (s == null || s.isEmpty()) {
      return false;
    }

    boolean[] table = new boolean[s.length() + 1];
    table[0] = true;

    for (int i=1; i<table.length; i++) {
      for (int k = 0; k<=i-1; k++) {
        if (table[k] && dict.contains(s.substring(k, i))) {
          table[i] = true;
          break;
        }
      }
    }

    return table[s.length()];
  }
}
