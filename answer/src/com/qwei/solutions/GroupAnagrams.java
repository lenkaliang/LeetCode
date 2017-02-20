package com.qwei.solutions;

import java.util.*;

/**
 * Given an array of strings, group anagrams together. For example, given: ["eat", "tea", "tan",
 * "ate", "nat", "bat"],
 *
 * Return: [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ]
 *
 * Straightforward implementation problem.
 */
public class GroupAnagrams {
  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> list = new ArrayList<>();

    if (strs == null || strs.length == 0) {
      return list;
    }

    Map<String, List<String>> map = new HashMap<String, List<String>>();

    for (String str : strs) {
      String key = sortString(str);
      if (map.containsKey(key)) {
        map.get(key).add(str);
      } else {
        List<String> group = new ArrayList<>();
        group.add(str);
        map.put(key, group);
      }
    }

    for (String key: map.keySet()) {
      list.add(map.get(key));
    }

    return list;
  }

  public static String sortString(String string) {
    if (string == null && string.length() < 2) {
      return string;
    }

    char[] array = string.toCharArray();
    Arrays.sort(array);

    StringBuffer buf = new StringBuffer();
    for (char c : array) {
      buf.append(c);
    }

    return buf.toString();
  }
}
