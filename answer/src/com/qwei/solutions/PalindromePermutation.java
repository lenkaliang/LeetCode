package com.qwei.solutions;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalindromePermutation {
  public static boolean canPermutePalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }

    int[] array = new int[128];

    for (int i=0; i<s.length(); i++) {
      array[s.charAt(i)] += 1;
    }

    int count = 0;
    for (int i=0; i<array.length; i++) {
      if (array[i] % 2 != 0) {
        count++;
        if (count == 2) {
          return false;
        }
      }
    }

    return true;
  }
}
