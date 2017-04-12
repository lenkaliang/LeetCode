package com.qwei.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-palindrome/#/description
 * 很好的一道题，真是他妈的考验智商啊。
 *
 * 一点值得注意：这个题目是问利用所有可以利用的字母能组成的最长的palindrome是多长
 */
public class LongestPalindrome {
  public int longestPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    Set<Character> set = new HashSet<>();
    int count = 0;

    for (int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      if (set.contains(c)) {
        set.remove(c);
        count++;
      } else {
        set.add(c);
      }
    }

    if (set.isEmpty()) {
      return count*2;
    } else {
      return count*2+1;
    }
  }
}
