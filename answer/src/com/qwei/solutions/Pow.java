package com.qwei.solutions;

/**
 * Implement pow(x, n).
 */
public class Pow {
  public static double pow(double x, int n) {
    if (n >= 0) {
      return helper(x, n);
    } else {
      return 1/helper(x, -n);
    }
  }

  // n >= 0
  public static double helper(double x, int n) {
    if (n == 0) {        //
      return 1;
    }

    double m = helper(x, n/2);
    if (n % 2 == 0) {
      return m * m;
    } else {
      return m * m * x;
    }
  }
}
