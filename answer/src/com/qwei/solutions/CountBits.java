package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.
 *
 * Example: For num = 5 you should return [0,1,1,2,1,2].
 *
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it
 * in linear time O(n) /possibly in a single pass?
 *
 * Space complexity should be O(n).
 *
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in
 * c++ or in any other language.
 *
 */
public class CountBits {
  // Good analysis: http://www.cnblogs.com/grandyang/p/5294255.html
  // The following methodis normal
  public static int[] countBits1(int num) {
    int[] zero = new int[] {0};
    if (num == 0) {
      return zero;
    }

    int k = 1;
    while (Math.pow(2, k) < num) {
      k++;
    }

    // num is between Math.pow(2, k-1) and Math.pow(2, k)
    List<Integer> list = new ArrayList<>();
    list.add(0);

    for (int i = 0; i <= k; i++) {
      List<Integer> newList = new ArrayList<>(list);
      for (int j = 0; j < list.size(); j++) {
        newList.add(list.get(j) + 1);
      }
      list = newList;
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      if (i == num) {
        break;
      }
      list.remove(i);
    }

    int[] array = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
    }

    return array;
  }

  // Best way, verify this with any example...
  public static int[] countBits(int num) {
    int[] res = new int[num+1];
    for (int i=1; i<=num; i++) {
      res[i] = res[i>>1] + (i & 1);
    }
    return res;
  }
}
