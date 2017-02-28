package com.qwei.solutions;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the
 * array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 * 1. 能跳到位置i的条件：i<=maxIndex
 * 2. 一旦跳到i，则maxIndex = max(maxIndex, i+A[i])
 * 3. 能跳到最后一个位置n-1的条件是：maxIndex >= n-1
 */
public class JumpGame {
  public static boolean canJump(int[] nums) {
    if (nums == null || nums.length < 2) {
      return true;
    }

    int max = nums[0]; // keeps an max jump value for the current index
    for (int i=1; i<nums.length; i++) {
      if (max >= nums.length-1) {
        return true;
      }

      if (i > max) {        // Above if has considered nums.length-1 case. So i is less than that
        return false;       // If the max index is less than i, it is not possible to jump out
      }

      max = Math.max(i + nums[i], max);        // corner case: [0,1]. Calculate max after two ifs
    }
    return false;
  }
}
