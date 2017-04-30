package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem description: https://leetcode.com/problems/output-contest-matches/#/description
 *
 * hint: It is obvious that the Matching Pattern is Strongest v.s. Weakest. Thus we keep create
 * Matching Group until there is only 1 group left.
 */
public class OutputContestMatches {
  public String findContestMatch(int n) {
    List<String> list = new ArrayList<>();

    for (int i=1; i<=n; i++) {
      list.add(i+"");
    }

    while (list.size() != 1) {
      List<String> newList = new ArrayList<>();

      int i=0, j=list.size()-1;
      while (i<j) {
        String left = "(" + list.get(i);
        String right = list.get(j) + ")";
        newList.add(left + "," + right);
        i++;
        j--;
      }
      list = newList;
    }
    return list.get(0);
  }
}
