package com.qwei.solutions;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example: input "babad", output "aba".
 */
public class LongestPalindromicSubstring {

  // First method : DP
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

  // second method : non DP
  public static String longestPalindromicStringNonDP(String s) {
    if (s == null || s.isEmpty()) {
      return "";
    }

    String longestPalindromicString = "";

    for (int i=0; i<=s.length()-1; i++) {
      // for each index, need to consider two scenarios (1.current i is center ('aba'); 2. i, i+1 both are center ('baab'))
      String a = findLongestPalindromicStringWithGivenIndex(s, i, i);
      String b = findLongestPalindromicStringWithGivenIndex(s, i, i+1);

      longestPalindromicString = longestPalindromicString.length() > a.length() ? longestPalindromicString : a;
      longestPalindromicString = longestPalindromicString.length() > b.length() ? longestPalindromicString : b;
    }
    return longestPalindromicString;
  }

  // helper function to find longest palindromic string by given start index and end index
  public static String findLongestPalindromicStringWithGivenIndex(String s, int start, int end) {
    if (s.isEmpty()) {
      return "";
    }

    if (start > end) {
      return "";
    }

    while (start >= 0 && end < s.length()) {
      if (s.charAt(start) != s.charAt(end)) {
        break;
      }
      start--;
      end++;
    }

    return s.substring(start+1, end);
  }
}
