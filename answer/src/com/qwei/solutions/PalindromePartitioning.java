package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
  public static List<List<String>> partition(String s) {
    List<List<String>> list = new ArrayList<>();

    if (s == null) {
      return list;
    }

    if (s.isEmpty()) {
      List<String> solution = new ArrayList<>();
      solution.add(s);
      list.add(solution);
      return list;
    }

    helper(list, s, new ArrayList<String>(), 0);
    return list;
  }

  public static void helper(List<List<String>> list, String s, List<String> temp, int pos) {
    if (pos == s.length()) {
      List<String> solution = new ArrayList<>(temp);
      list.add(solution);
      return;
    }

    for (int i=pos+1; i<=s.length(); i++) {         // i can be s.length() because i is the second arg of substring()
      String sub = s.substring(pos, i);
      if (isPalindrome(sub)) {
        temp.add(sub);
        helper(list, s, temp, i);
        temp.remove(temp.size()-1);
      }
    }
  }

  public static boolean isPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }

    for (int i=0, j=s.length()-1; i<=j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}
