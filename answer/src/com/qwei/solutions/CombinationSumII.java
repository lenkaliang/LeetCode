package com.qwei.solutions;

import java.util.*;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 * in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 *
 * Note: All numbers (including target) will be positive integers. The solution set must not contain
 * duplicate combinations.
 *
 * The difference between this and I is, the number in I can be used unlimited times in a set
 */
public class CombinationSumII {
  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    if (candidates == null || candidates.length == 0) {
      return list;
    }

    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(candidates);

    helper(candidates, target, list, new ArrayList<Integer>(), set, 0);
    return list;
  }

  public static void helper(int[] candidates, int target, List<List<Integer>> list,
      List<Integer> temp, Set<List<Integer>> set, int step) {
    int sum = 0;
    for (Integer integer : temp) {
      sum = sum + integer;
    }

    if (sum == target) {
      if (set.add(temp)) {
        List<Integer> solution = new ArrayList<>(temp);
        list.add(solution);
      }
      return;
    }

    if (step == candidates.length) {        // This condition cannot be put in the beginning.It will override the sum == target case for candidiates=[1], target=1
      return;
    }

    if (sum > target) {
      return;
    }

    for (int i = step; i < candidates.length; i++) {
      temp.add(candidates[i]);
      helper(candidates, target, list, temp, set, i + 1); // each element can be used only once
      temp.remove(temp.size() - 1); // remove the last element used (在哪家的在哪删除)
    }
  }
}
