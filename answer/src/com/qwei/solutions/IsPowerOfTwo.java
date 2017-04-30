package com.qwei.solutions;

/**
 * Write a funcion to determine if an integet is a power of two
 *
 * 规律就是如果一个数是2的n次方，那么这个数的二进制表示里只有一个1
 */
public class IsPowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    return n>0 && Integer.bitCount(n) == 1;
  }
}
