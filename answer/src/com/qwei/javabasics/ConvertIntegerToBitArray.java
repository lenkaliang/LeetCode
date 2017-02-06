package com.qwei.javabasics;

import java.util.Arrays;

/**
 * This class's method shows how to convert a interger to a bit array.
 *
 * Assume a is positive.
 *
 * Background: 10 & 1 = 0 ( 1010 & 0001 = 0000 )
 *              7 & 1 = 1 ( 0111 & 0001 = 0001 )
 *
 * Example:
 * 7 >> 0 & 1 = 1, this implies bit[0] = 1;
 * 7 >> 1 & 1 = 1, this implies bit[1] = 1;
 * 7 >> 2 & 1 = 1, this implies bit[2] = 1;
 * 7 >> 3 == 0, bit[3] = 0;
 */
public class ConvertIntegerToBitArray {
  public static int[] convert(int a) {
    int[] bit = new int[32];
    Arrays.fill(bit, 0);

    for (int i=0; i<bit.length; i++) {
      int temp = a >> i;
      if (temp == 0) {
        break;
      }
      bit[i] = temp & 1;
    }

    return bit;
  }
}
