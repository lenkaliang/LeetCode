package com.qwei.solutions;

import java.util.ArrayList;

/**
 * Find out the maximum sub-array of non negative numbers from an array. The sub-array should be
 * continuous. That is, a sub-array created by choosing the second and fourth element and skipping
 * the third element is invalid.
 *
 * Be care of two corner cases: [-1,-1,-1,-1], [0,0,0,0]
 */
public class MaxNonNegativeSubarray {
  public static ArrayList<Integer> maxSet(ArrayList<Integer> a) {
    if (a == null || a.size() == 0 || a.size() == 1) {
      return a;
    }

    ArrayList<Integer> result = new ArrayList<Integer>();
    ArrayList<Integer> temp = new ArrayList<Integer>();
    int maxSum = 0;
    int sum = a.get(0);
    int first = 0;
    int second = 1;


    temp.add(a.get(first));
    while (second < a.size()) {
      if (a.get(second) < 0) {
        if (maxSum <= sum) {
          maxSum = sum;
          for (Integer i : temp) {
            result.add(i);
          }
        }
        temp.clear();
        first = second + 1;
        if (first < a.size() && a.get(first) >= 0) {
          temp.add(a.get(first));
          sum = a.get(first);
        }
        second = first + 1;
      } else {
        temp.add(a.get(second));
        sum += a.get(second);
        second++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();



    System.out.println(maxSet(list));
  }
}
