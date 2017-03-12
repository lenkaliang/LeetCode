package com.qwei.solutions;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding
 * bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 * Note: 0 ≤ x, y < Integer.MAX_VALUE
 *
 * Example please refer from here: https://leetcode.com/problems/hamming-distance/?tab=Description
 */
public class HammingDistance {
  public static int  hammingDistance(int x, int y) {
    int value = x ^ y;
    int distance = 0;

    while (value != 0) {
      if ((value & 1) == 1) {
        distance++;
      }
      value = value >> 1;
    }
    return distance;
  }
}
