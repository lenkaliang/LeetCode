package com.qwei.solutions;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d =
 * target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Similar to ThreeSum (Remember to sort the array)
 */
public class FourSum {
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();

    if (nums == null || nums.length < 4) {
      return ret;
    }

    Arrays.sort(nums);

    Set<List<Integer>> set = new HashSet<List<Integer>>();   // Will be used for finding the unique combo
    for (int i=0; i<nums.length; i++) {

      // inside here is three sum
      for (int j=i+1; j<nums.length; j++) {
        int k = j + 1;
        int l = nums.length - 1;
        while (k < l) {
          int currSum = nums[i] + nums[j] + nums[k] + nums[l];
          if (currSum == target) {
            List<Integer> sample = new ArrayList<Integer>();
            sample.add(nums[i]);
            sample.add(nums[j]);
            sample.add(nums[k]);
            sample.add(nums[l]);
            if (set.add(sample)) {
              ret.add(sample);
            }
            k++;
            l--;
          } else if (currSum < target) {
            k++;
          } else {
            l--;
          }
        }
      }
    }
    return ret;
  }
}
