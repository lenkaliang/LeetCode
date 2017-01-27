package com.qwei.solutions;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * For Bitwise operators：
 * NOT :  1 -> 0, 0 -> 1
 * AND (&) : 1 & 1 = 1, 1 & 0 = 0 & 0 = 0
 * XOR (^) : same = 0, not same = 1
 * OR (|) : if 1 exists = 1
 *
 * 0 ^ anynumber = this number
 */
public class SingleNumber {
  public static int singleNumber(int[] nums) {
    int ret = 0;
    for (int i : nums) {
      ret = ret ^ i;
    }
    return ret;
  }
}
