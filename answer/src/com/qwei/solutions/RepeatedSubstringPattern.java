package com.qwei.solutions;

/**
 * Description goes here: https://leetcode.com/problems/repeated-substring-pattern/#/solutions
 * 
 * The length of the repeating substring must be a divisor of the length of the input string
 * Search for all possible divisor of str.length, starting for length/2
 * If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
 * If the repeated substring is equals to the input str return true
 */
public class RepeatedSubstringPattern {
  public boolean repeatedSubstringPattern(String str) {
    int length = str.length();
    int len = length/2;

    while (len > 0) {
      if (length % len == 0) {
        int count = length / len;
        String sub = str.substring(0, len);
        StringBuffer buf = new StringBuffer();

        for (int i=0; i<count; i++) {
          buf.append(sub);
        }

        if (buf.toString().equals(str)) {
          return true;
        }
      }
      len--;
    }
    return false;
  }
}
