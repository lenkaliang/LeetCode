package com.qwei.solutions;

/**
 * Given two binary strings, return their sum (also a binary string). For example, a = "11" b = "1"
 * Return "100".
 */
public class AddBinary {
  public static String addBinary(String a, String b) {
    if (a == null || a.isEmpty()) {
      return b;
    }
    if (b == null || b.isEmpty()) {
      return a;
    }

    StringBuffer buf = new StringBuffer();
    int i = a.length() - 1, j = b.length() - 1;
    int carry = 0;
    while (i >= 0 && j >= 0) {
      int sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
      carry = sum / 2;
      buf.insert(0, sum % 2);
      i--;
      j--;
    }

    if (i < 0) {
      while (j >= 0) {
        int sum = (b.charAt(j) - '0') + carry;
        carry = sum / 2;
        buf.insert(0, sum % 2);
        j--;
      }
    } else {
      while (i >= 0) {
        int sum = (a.charAt(i) - '0') + carry;
        carry = sum / 2;
        buf.insert(0, sum % 2);
        i--;
      }
    }
    if (carry > 0) {
      buf.insert(0, carry);
    }
    return buf.toString();
  }
}
