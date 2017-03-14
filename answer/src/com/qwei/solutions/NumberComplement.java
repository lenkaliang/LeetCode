package com.qwei.solutions;

import org.jetbrains.annotations.Contract;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the
 * bits of its binary representation.
 *
 * Note:
 * 1.The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * 2.You could assume no leading zero bit in the integer’s binary representation.
 *
 * Example:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is
 * 010. So you need to output 2.
 *
 */
public class NumberComplement {
  public static int findComplement(int num) {
    StringBuffer buf = new StringBuffer();

    while (num != 0) {
      if ((num & 1) == 1) {
        buf.insert(0,1);
      } else {
        buf.insert(0,0);
      }
      num = num >> 1;
    }

    // 取反，并且从二进制换算到十进制
    int sum = 0;
    for (int i=buf.length()-1; i>=0; i--) {
      if (buf.charAt(i) == '0') {
        sum = sum + (int)Math.pow(2, buf.length()-i-1);
      }
    }
    return sum;
  }

  @Contract(pure = true)
    public static int findComplement2(int num) {
    int mask = (Integer.highestOneBit(num) << 1) -1;
    num = ~num;
    return num & mask;
  }
}
