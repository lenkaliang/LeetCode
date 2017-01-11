package com.qwei.solutions;

/**
 * Reverse digits of an integer. Example1: x = 123, return 321 Example2: x = -123, return -321
 *
 * Consider case1: 10, 100 Consider case2: stack overflow
 */
public class ReverseInteger {
  public static Integer reverse(Integer integer) {
    boolean negative = false;
    if (integer < 0) {
      negative = true;
      integer = Math.abs(integer);
    }

    Integer ret = 0;
    while (integer > 0) {
      int mod = integer % 10;
      if (ret > Integer.MAX_VALUE / 10
          || (!negative && ret == Integer.MAX_VALUE && mod > Integer.MAX_VALUE % 10)
          || (negative && ret == Math.abs(Integer.MIN_VALUE) && mod > Math.abs(Integer.MIN_VALUE) % 10)) {
        return 0;
      }
      ret = ret * 10 + mod;
      integer = integer / 10;
    }

    if (negative) {
      return -ret;
    }
    return ret;
  }
}
