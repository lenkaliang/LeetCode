package com.qwei.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description goes here: https://leetcode.com/problems/binary-watch/#/description
 *
 * Pratice of how to use recursive to look for the subset of an array
 */
public class BinaryWatch {
  public static void main(String[] args) {
    BinaryWatch watch = new BinaryWatch();
    List<String> list = watch.readBinaryWatch(4);
    Collections.sort(list);
    System.out.println(list);

  }
  public List<String> readBinaryWatch(int num) {
    List<String> times = new ArrayList<>();
    if (num > 8) {
      return times;
    }

    if (num == 0) {
      times.add("0:00");
      return times;
    }

    int[] hours = new int[]{8, 4, 2, 1};
    int[] mins = new int[]{32, 16, 8, 4, 2, 1};

    for (int numberOfHours=0; numberOfHours<=3; numberOfHours++) {
      int numberOfMins = num - numberOfHours;
      if (numberOfMins >= mins.length) {
        continue;
      }
      List<Integer> hourSums = getSubsetSum(hours, numberOfHours);
      List<Integer> minSums = getSubsetSum(mins, numberOfMins);

      for (Integer h: hourSums) {
        if (h > 11) {
          continue;
        }
        for (Integer m: minSums) {
          if (m >= 60) {
            continue;
          }
          if (m < 10) {
            times.add(h + ":0" + m);
          } else {
            times.add(h + ":" + m);
          }
        }
      }
    }
    return times;
  }

  public List<Integer> getSubsetSum(int[] num, int n) {
    List<Integer> sums = new ArrayList<>();
    helper(num, n, new ArrayList<>(), sums, 0);
    return sums;
  }

  public void helper(int[] num, int n, List<Integer> combo, List<Integer> sums, int index) {
    if (combo.size() == n) {
      int sum = 0;
      for (Integer i: combo) {
        sum += i;
      }
      sums.add(sum);
      return;
    }

    for (int i=index; i<num.length; i++) {
      combo.add(num[i]);
      helper(num, n, combo, sums, i+1);
      combo.remove(combo.size()-1);
    }
  }
}
