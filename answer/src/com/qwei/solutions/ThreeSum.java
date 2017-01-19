package com.qwei.solutions;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all
 * unique triplets in the array which gives the sum of zero
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 *
 * This problem is achieved by 3 pointers on top of sort
 */
public class ThreeSum {
  public static List<List<Integer>> findCombination(int[] nums) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    Set<List<Integer>> duplicateCheckSet = new HashSet<List<Integer>>();
    if (nums == null || nums.length < 3) {
      return ret;
    }

    Arrays.sort(nums);
    for (int i=0; i<nums.length; i++) {
      int j= i + 1;
      int k = nums.length - 1;
      while(j < k) {
        List<Integer> onecase = new ArrayList<Integer>();
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          onecase.add(nums[i]);
          onecase.add(nums[j]);
          onecase.add(nums[k]);

          if (duplicateCheckSet.add(onecase)) {
            ret.add(onecase);
          }
          j++;
          k--;
        } else if (sum > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
    return ret;
  }
}
