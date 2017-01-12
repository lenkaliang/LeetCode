package com.qwei.solutions;

/**
 * Determine whether an integer is a palindrome. Do this without extra space. Good corner cases: 1.
 * 10000021 2. 1000000001 (fac will get out of int bound)
 */
public class PalindromeNumber {
  public static boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    int fac = 1;
    while (x / fac >= 10) {
      fac = fac * 10;
    }

    boolean isPalindrome = true;
    while (x > 0) {
      int left = x / fac;
      int right = x % 10;
      if (left != right) {
        isPalindrome = false;
        break;
      }

      x = (x % fac) / 10;
      fac = fac / 100;
    }

    return isPalindrome;
  }

}
