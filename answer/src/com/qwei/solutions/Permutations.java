package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * For example, [1,2,3] have the following permutations: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1],
 * [3,1,2], [3,2,1] ]
 *
 * Understand how to manipulate references
 */
public class Permutations {
  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ret = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return ret;
    }
    List<Integer> empty = new ArrayList<>();
    ret.add(empty);
    for (int i : nums) {
      ret = insertElement(ret, i);
    }
    return ret;
  }

  public static List<List<Integer>> insertElement(List<List<Integer>> list, int number) {
    List<List<Integer>> newList = new ArrayList<>();
    for (List<Integer> eachCombo : list) {
      for (int i = 0; i <= eachCombo.size(); i++) {
        List<Integer> newCombo = new ArrayList<>(eachCombo);
        newCombo.add(i, number);
        newList.add(newCombo);
      }
    }
    return newList;
  }
}
