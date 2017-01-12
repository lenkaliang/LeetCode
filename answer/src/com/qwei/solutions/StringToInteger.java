package com.qwei.solutions;

/**
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional initial
 * plus or minus sign followed by as many numerical digits as possible, and interprets them as a
 * numerical value.
 * 
 * The string can contain additional characters after those that form the integral number, which are
 * ignored and have no effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if
 * no such sequence exists because either str is empty or it contains only whitespace characters, no
 * conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out
 * of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger {
  public static int myAtoi(String str) {
    if (str == null || str.isEmpty()) {
      return 0;
    }

    str = str.trim();

    // determine the sign
    boolean negative = false;
    int index = 0;
    if (str.charAt(index) != '+' && str.charAt(index) != '-'
        && (str.charAt(index) < '0' || str.charAt(index) > '9')) {
      return 0;
    } else if (str.charAt(index) == '-') {
      negative = true;
      index++;
    } else if (str.charAt(index) == '+') {
      index++;
    }

    int ret = 0;
    while (index < str.length()) {
      char c = str.charAt(index);
      int digit = c - '0';
      if (digit > 9 || digit < 0) {
        break;
      }

      // To see it is going to excceed the scope
      if (!negative && (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)){
        return Integer.MAX_VALUE;
      } else if (negative && (ret > Math.abs(Integer.MAX_VALUE / 10) || ret == Math.abs(Integer.MAX_VALUE / 10) && digit > Math.abs(Integer.MIN_VALUE % 10))) {
        return Integer.MIN_VALUE;
      }

      ret = ret * 10 + digit;
      index++;
    }

    if (negative) {
      return -ret;
    }

    return ret;
  }
}
