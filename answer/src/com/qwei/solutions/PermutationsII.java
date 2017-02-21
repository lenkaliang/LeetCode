package com.qwei.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique
 * permutations.
 *
 * This is looking for all permutations, not subsets
 */
public class PermutationsII {
  public static List<List<Integer>> permutationII(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return list;
    }

    Set<List<Integer>> set = new HashSet<>();
    list.add(new ArrayList<Integer>());
    for (int i: nums) {
      list = insert(list, set, i);
    }

    return list;
  }

  public static List<List<Integer>> insert(List<List<Integer>> list, Set<List<Integer>> set, int nthNumber) {
    List<List<Integer>> newList = new ArrayList<>();
    for (List<Integer> oneList : list) {
      for (int i=0; i<=oneList.size(); i++) {
        List<Integer> temp = new ArrayList<>(oneList);
        temp.add(i, nthNumber);
        if (set.add(temp)) {
          newList.add(temp);
        }
      }
    }
    return newList;
  }
}
