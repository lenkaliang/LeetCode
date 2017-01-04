package com.qwei.solutions;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example: input "babad", output "aba".
 */
public class LongestPalindromicSubstring {
  public static String longestPalindromeDP(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }

    int len = s.length();
    boolean[][] table = new boolean[len][len];
    String longestPalindrom = "";

    // if table[i][j] == true, means substring from i to j is palindromic
    // else it is not palindromic
    // To evaluate table[i][j], evaluate charAt(i) == charAt(j) && table[i+1][j-1]

    for (int i=0; i<len; i++) {  // each char in the string is palindromic
      table[i][i] = true;
    }

    for (int i=0; i<len-1; i++) { // if two consecutive chars are same, they are palindromic
      if (s.charAt(i) == s.charAt(i+1)) {
        table[i][i+1] = true;
      }
    }

    for (int l=3; l<=len; l++) {  // Substring whose length is more than or equals 3, maximum length can be length of the string
      for (int i=0; i<=len-l; i++) {
        int j = i + l - 1;       // the end index of the substring which is palindromic tested
        if (s.charAt(i) == s.charAt(j) && table[i+1][j-1]) {
          table[i][j] = true;
        }
      }
    }

    for (int i=0; i<len; i++) {  // evaluate the longest palindromic substring
      for (int j=i; j<len; j++) {
        if (table[i][j] && j-i+1 > longestPalindrom.length()) {
          longestPalindrom = s.substring(i, j+1);
        }
      }
    }
    return longestPalindrom;
  }
}
