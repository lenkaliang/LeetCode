package com.qwei.solutions;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
 * sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 *
 * This problem is asking to find each rising trend
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
