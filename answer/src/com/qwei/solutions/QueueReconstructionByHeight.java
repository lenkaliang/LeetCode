package com.qwei.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Desription goes here: https://leetcode.com/problems/queue-reconstruction-by-height/#/description
 *
 * Sort the whole array and sort insert each element in terms of highest element to lowest element
 */
public class QueueReconstructionByHeight {
  public int[][] reconstructQueue(int[][] people) {
    if (people == null || people.length == 0) {
      return people;
    }

    Arrays.sort(people, new Comparator<int[]>() {
      // This is called anonymous class whcih doesn't have name and implements the Comparator
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          // if heights are same, then order in terms of the index
          return o1[1] - o2[1];
        } else {
          return o2[0] - o2[0];
        }
      }
    });

    List<int[]> list = new ArrayList<>();
    for (int[] each: people) {
      list.add(each[1], each);
    }

    return list.toArray(new int[people.length][]);
  }
}
