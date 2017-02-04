package com.qwei.solutions;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and
 * ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good question to ask during an
 * interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
  public static boolean validPalindrome(String s) {
    boolean isPalindrome = true;
    if (s == null || s.isEmpty()) {
      return isPalindrome;
    }

    s = s.trim().toLowerCase();
    int i = 0, j = s.length()-1;
    while (i <= j) {
      if (s.charAt(i) == ' ' || !isValid(s.charAt(i))) {
        i++;
        continue;
      }

      if (s.charAt(j) == ' ' || !isValid(s.charAt(j))) {
        j--;
        continue;
      }

      if (s.charAt(i) != s.charAt(j)) {
        isPalindrome = false;
      }
      i++;
      j--;
    }
    return isPalindrome;
  }

  public static boolean isValid(char c) {
    return 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9';
  }
}
