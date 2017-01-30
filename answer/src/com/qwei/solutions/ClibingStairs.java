package com.qwei.solutions;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 */
public class ClibingStairs {
  public static int clibingStairs(int n) {
    if (n < 2) {
      return 1;
    }
    int[] table = new int[n];   // table[i] is the number of ways of clibing the i+1 stairs

    table[0] = 1;
    table[1] = 2;
    for (int i=2; i<n; i++) {
      table[i] = table[i-1] + table[i-2];
    }
    return table[n-1];
  }
}
