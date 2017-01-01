package com.qwei.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target. You may assume that each input would have exactly one solution.
 *
 *
 */
public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    int[] ans = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        // found the one
        ans[0] = map.get(nums[i]);
        ans[1] = i;
      } else {
        map.put(target - nums[i], i);
      }
    }
    return ans;
  }
}
