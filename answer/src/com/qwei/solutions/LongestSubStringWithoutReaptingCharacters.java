package com.qwei.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples: Given "abcabcbb", the answer is "abc", which the length is 3. Given "bbbbb", the answer
 * is "b", with the length of 1. Given "pwwkew", the answer is "wke", with the length of 3. Note
 * that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubStringWithoutReaptingCharacters {
  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }

    int i = 0;
    int j = 0;
    int max = 0;
    int[] map = new int[256];

    while (i < s.length()) {
      while (j < s.length() && map[s.charAt(j)] == 0) {
        map[s.charAt(j)] = 1;
        max = Math.max(max, j - i + 1);
        j++;
      }
      // Before the next round, reset the current round starting letter's position in map.
      map[s.charAt(i)] = 0;
      i++;
    }
    return max;
  }
}
