package com.qwei.solutions;

import java.util.*;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note: All numbers (including target) will be positive integers. The solution set must not contain
 * duplicate combinations.
 */
public class CombinationSum {
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    if (candidates == null || candidates.length == 0 || target <= 0) {
      return list;
    }
    // this algorithm is based on ordered integer array
    Arrays.sort(candidates);

    Set<List<Integer>> set = new HashSet<>();
    helper(candidates, target, list, set, new ArrayList<>(), 0);
    return list;
  }

  public static void helper(int[] candidates, int target, List<List<Integer>> list,
      Set<List<Integer>> set, List<Integer> temp, int step) {
    int sum = 0;
    for (int i: temp) {
      sum += i;
    }

    if (sum > target) {
      return;
    }
    if (sum == target) {
      List<Integer> oneCombo = new ArrayList<>(temp);
      if (set.add(oneCombo)) {
        list.add(oneCombo);
      }
      return;
    }

    for (int i=step; i<candidates.length; i++) {
      temp.add(candidates[i]);
      helper(candidates, target, list, set, temp, i);      // use i instead of step !!!!
      temp.remove(temp.size()-1);
    }
  }

}
