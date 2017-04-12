package com.qwei.solutions;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
 * sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 *
 * 寻找这个数组中所有的上升区间。上升区间里面每两个相邻的数取差值。然后求差值之和。
 */
public class BestTOBuyAndSellStock {
  public static int maxProfit(int[] prices) {
    int max = 0;

    for (int index=0; index<prices.length-1; index++) {
      if (prices[index] < prices[index + 1]) {
        max += prices[index+1] - prices[index];
      }
    }
    return max;
  }
}
