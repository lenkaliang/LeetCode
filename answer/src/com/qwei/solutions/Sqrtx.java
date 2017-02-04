package com.qwei.solutions;

/**
 * Implement int sqrt(int x).
 *
 * Binary search
 *
 * Note: use long
 */
public class Sqrtx {
  public static int sqrt(int x) {
    if (x < 0) {
      return 0;
    }

    long low = 0, high = x;
    while (low <= high) {
      long mid = (low + high) / 2;
      long square = mid * mid;
      if (square == (long)x) {
        return (int)mid;
      } else if (square < x) {
        low++;
      }else {
        high--;
      }
    }
    return (int)((low + high) / 2);
  }
}
