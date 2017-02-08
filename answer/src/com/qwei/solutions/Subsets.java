package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 *
 * Note: consider the empty subset
 */
public class Subsets {
  public static List<List<Integer>> getSubSets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return list;
    }

    List<Integer> bucket = new ArrayList<>();   // will be used to collect numbers of each subset
    List<Integer> empty = new ArrayList<>();

    list.add(empty);
    helper(list, bucket, nums, 0);
    return list;
  }

  public static void helper(List<List<Integer>> list, List<Integer> bucket, int[] nums, int n) {
    if (n >= nums.length) {
      return;
    }

    for (int i=n; i<nums.length; i++) {         // Getting all the subsets of nums starting from index n
      bucket.add(nums[i]);
      List<Integer> oneCombo = new ArrayList<>(bucket);
      list.add(oneCombo);
      helper(list, bucket, nums, i+1);
      bucket.remove(bucket.size()-1);
    }
  }
}
