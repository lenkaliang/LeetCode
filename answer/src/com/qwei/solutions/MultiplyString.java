package com.qwei.solutions;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1
 * and num2.
 *
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 * How:
 * 1. m位的数字乘以n位的数字的结果最大为m+n位：999*99 < 1000*100 = 100000，最多为3+2 = 5位数。
 * 2. 先将字符串逆序便于从最低位开始计算。
 *
 */
public class MultiplyString {
  public static String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }

    int[] table = new int[num1.length() + num2.length()];

    StringBuffer number1 = new StringBuffer(num1).reverse();
    StringBuffer number2 = new StringBuffer(num2).reverse();

    // initialize table
    for (int i=0; i<number1.length(); i++) {
      for (int j=0; j<number2.length(); j++) {
        table[i+j] = table[i+j] + (number1.charAt(i) - '0') * (number2.charAt(j) - '0');
      }
    }

    // construct the ans
    StringBuffer buf = new StringBuffer();
    int carry = 0;
    for (int i=0; i<table.length; i++) {
      int currSum = table[i] + carry;
      int digit = currSum % 10;
      carry = currSum / 10;
      buf.append(digit);
    }

    // get rid of leading 0s
    for (int i=buf.length()-1; i>=0; i--) {
      if (buf.charAt(i) == '0') {
        buf.deleteCharAt(i);
      } else {
        break;
      }
    }

    // reverse the number to get the production
    return buf.reverse().toString();
  }
}
