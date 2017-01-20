package com.qwei.solutions;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given
 * number, target. Return the sum of the three integers. You may assume that each input would have
 * exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
  public static int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length < 3) {
      return 0;
    }
    // Array must be sorted
    Arrays.sort(nums);
    int closestSum = nums[0] + nums[1] + nums[2];
    for (int i=0; i<nums.length; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == target) {
          return sum;
        } else {
          closestSum = Math.abs(closestSum - target) < Math.abs(sum - target) ? closestSum : sum;
          if (sum < target) {
            j++;
          } else {
            k--;
          }
        }
      }
    }
    return closestSum;
  }
}
