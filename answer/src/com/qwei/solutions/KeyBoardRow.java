package com.qwei.solutions;

import java.util.*;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one
 * row's of American keyboard
 *
 * Example 1: Input: ["Hello", "Alaska", "Dad", "Peace"] Output: ["Alaska", "Dad"]
 *
 * Note: You may use one character in the keyboard more than once You may assume the input string
 * will only contain letters of alphabet.
 */
public class KeyBoardRow {
  public static String[] findWords(String[] words) {
    if (words == null || words.length == 0) {
      return words;
    }

    Map<Integer, List<Character>> map = new HashMap<>();
    map.put(1, Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
    map.put(2, Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
    map.put(3, Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

    List<String> list = new ArrayList<>();
    for (String string : words) {
      String s = string.toLowerCase();
      if (s == null || s.length() == 0) {
        continue;
      }

      if (s.length() < 2) {
        list.add(string);
        continue;
      }

      int line = 0;
      if (map.get(1).contains(s.charAt(0))) {
        line = 1;
      } else if (map.get(2).contains(s.charAt(0))) {
        line = 2;
      } else {
        line = 3;
      }

      boolean sameLine = true;
      for (int i = 1; i < s.length(); i++) {
        if (!map.get(line).contains(s.charAt(i))) {
          sameLine = false;
          break;
        }
      }
      if (sameLine) {
        list.add(string);
      }
    }
    String[] ans = new String[list.size()];
    for (int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }
    return ans;
  }
}
