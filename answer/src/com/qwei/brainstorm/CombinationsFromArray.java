package com.qwei.brainstorm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qwei1 on 4/2/17.
 */
public class CombinationsFromArray {
  public List<List<Integer>> getCombo(int[] numbers, int k) {
    List<List<Integer>> list = new ArrayList<>();
    if (numbers == null || numbers.length == 0 || k == 0 || k > numbers.length) {
      return list;
    }

    helper(numbers, k, list, 0, new ArrayList<Integer>());
    return list;
  }

  public void helper(int[] numbers, int k, List<List<Integer>> list, int index, List<Integer> temp) {
    if (temp.size() == k) {
      List<Integer> newTemp = new ArrayList<Integer>(temp);
      list.add(newTemp);
      return;
    }

    for (int i=index; i<numbers.length; i++) {
      temp.add(numbers[i]);
      helper(numbers, k, list, i+1, temp);
      temp.remove(temp.size()-1);
    }
  }

  public static void main(String[] args) {
    int[] numbers = new int[]{1,2,3,4,5,6,7};

    System.out.print(new CombinationsFromArray().getCombo(numbers, 1));
  }
}
