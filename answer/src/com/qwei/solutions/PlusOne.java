package com.qwei.solutions;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 *
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
  public static int[] plusOne(int[] digits) {
    if (digits == null || digits.length == 0) {
      return new int[] {1};
    }

    int carry = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      int sum = 0;
      if (i == digits.length - 1) {
        sum += digits[i] + 1;
        carry = sum / 10;
        digits[i] = sum % 10;
      } else {
        sum = digits[i] + carry;
        digits[i] = sum % 10;
        carry = sum / 10;
      }
    }

    if (carry > 0) {
      int[] ret = new int[digits.length + 1];
      ret[0] = carry;
      for (int i = 1; i < ret.length; i++) {
        ret[i] = digits[i - 1];
      }
      return ret;
    }
    return digits;
  }

  // the following methd are more clear than above for this specific problem
  public static int[] plusOne2(int[] digits) {
    if (digits == null || digits.length == 0)
      return digits;

    int carry = 1;
    for (int i=digits.length-1; i>=0; i--) {
      if (digits[i] + carry == 10) {
        digits[i] = 0;
        carry = 1;
      } else {
        digits[i] += carry;
        carry = 0;
      }
    }

    if (carry == 1) {
      int[] ret = new int[digits.length + 1];
      ret[0] = carry;
      for (int i = 1; i < ret.length; i++) {
        ret[i] = digits[i - 1];
      }
      return ret;
    }
    return digits;
  }
}
