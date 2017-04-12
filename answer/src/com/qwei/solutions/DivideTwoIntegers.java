package com.qwei.solutions;

/**
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 *
 * For this coding problem, you need to understand how "<<" works.
 * 1011 << 1 -> 10110, which means multiply 2.
 * 1011 << 2 -> 101100, which means multiply 4
 * ...
 * ">>" means divided by 2
 *
 * 这个算法是以long基础的。所有的变量都是long。
 */
public class DivideTwoIntegers {
  public static int divide(int dividend, int divisor) {
    // corner case
    if (divisor == 0) {
      return  dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    // corner case
    if (dividend == 0) {
      return 0;
    }

    // corner case : overflow
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    long num1 = Math.abs((long)dividend);
    long num2 = Math.abs((long)divisor);

    long shift = 1; // this will be used to get maximum bit shift  ---  注意type是long
    while (num1 >= num2) {
      num2 = num2 << 1;     // keep multiplying 2
      shift =  shift << 1;  // keep multiplying 2
    }

    long ret = 0;
    while (num1 >= Math.abs((long)divisor)) {
      while (num1 >= num2) {
        num1 = num1 - num2;
        ret = ret + shift;
      }
      num2 = num2 >> 1;
      shift = shift >> 1;
    }

    boolean negative = false;
    negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

    if (negative) {
      return -(int)ret;
    }
    return (int)ret;
  }
}
