package com.qwei.solutions;

import java.util.*;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 */
public class SubsetsII {
  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return list;
    }

    List<Integer> empty = new ArrayList<>();
    list.add(empty);
    Arrays.sort(nums);
    Set<List<Integer>> set = new HashSet<>();

    helper(list, nums, set, new ArrayList<Integer>(), 0);

    return list;
  }

  public static void helper(List<List<Integer>> list, int[] nums, Set<List<Integer>> set, List<Integer> temp, int step) {
    if (step == nums.length) {
      return;
    }

    for (int index = step; index < nums.length; index++) {
      temp.add(nums[index]);
      if (set.add(temp)) {
        List<Integer> combo = new ArrayList<>(temp);
        list.add(combo);
      }

      helper(list, nums, set, temp, index+1);  // here you cannot use ++index, this will cause index = index + 2 within one loop
      temp.remove(temp.size() - 1);
    }
  }
}
