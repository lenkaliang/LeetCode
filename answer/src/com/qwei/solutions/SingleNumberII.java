package com.qwei.solutions;

import java.util.Arrays;

/**
 * Given an array of integers, every element appears three times except for one, which appears
 * exactly once. Find that single one.
 *
 * if a number & 1 == 0, means this number is a even number.
 * if a number & 1 == 1, means this number is a odd number.
 */
public class SingleNumberII {
  public static int singleNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int[] bit = new int[32];
    Arrays.fill(bit, 0);

    // fill the bit array
    for (int i=0; i<nums.length; i++) {
      for (int j=0; j<bit.length; j++) {     // bit.length is a 32, considered as O(1) complexity
        int tmp = nums[i] >> j;
        if (tmp == 0) {                      // last loop find the highest position in bit array
          break;
        }
        bit[j] = bit[j] + tmp & 1;
      }
    }

    int target = 0;
    for (int i=0; i<bit.length; i++) {
      target = target + (bit[i] % 3) << i;
    }
    return target;
  }
}
