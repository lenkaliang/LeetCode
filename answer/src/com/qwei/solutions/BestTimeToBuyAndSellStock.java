package com.qwei.solutions;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of
 * the stock), design an algorithm to find the maximum profit.
 *
 * 每到一个位置：
 * 维护一个最小值，Math.min(min, prices[i]).
 * 计算一次当前卖股票的利润。与之前的最大值做比较。取一个更大的值。
 */
public class BestTimeToBuyAndSellStock {
  public static int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
      return 0;
    }

    int min = Integer.MAX_VALUE;
    int maxProfit = Integer.MIN_VALUE;

    for (int i=0; i<prices.length; i++) {
      min = Math.min(min, prices[i]);
      maxProfit = Math.max(maxProfit, prices[i] - min);
    }

    return maxProfit;
  }
}
