package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the
 * sequence of gray code. A gray code sequence must begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is: 00 - 0 01 - 1 11 - 3 10 -
 * 2
 *
 * Note: For a given n, a gray code sequence is not uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 *
 * This problem is testing how to use previous generated collection
 */
public class GrayCode {
  //规律：n时的Gray Code，相当于n-1时的Gray Code的逆序 加上 1<<n-1
  // n = 0, gray code {0}
  // n = 1, gray code {0, 1}
  // n = 2, (gray code n=1's gray code {00, 01}) U (reverse {00, 01} + 1<<n-1 {01 + 10, 00 + 10})
  // same when n = 3;
  // reverse means to reverse the List, not reverse bit code!!!!
  public static List<Integer> grayCode(int n) {
    List<Integer> list = new ArrayList<>();
    list.add(0);
    if (n == 0) {
      return list;
    }
    for (int i=1; i<=n; i++) {
      List<Integer> temp = new ArrayList<>(list);
      int numberToAdd = 1<<i-1;
      for (int j=temp.size()-1; j>=0; j--) {
        list.add(temp.get(j) + numberToAdd);
      }
    }
    return list;
  }
}
