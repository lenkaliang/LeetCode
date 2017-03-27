package com.qwei.solutions;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also
 * known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
 * so the function should return 3.
 */
public class NumberOf1Bits {
  // incorrect code (bug:   2147483648 (10000000000000000000000000000000))
  public int hammingWeight1(int n) {
    int number = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        number++;
      }
      n = n >> 1;
    }
    return number;
  }

  // working version
  public int hammingWeight(int n) {
    int number = 0;
    for (int i=0; i<32; i++) {
      if (getBit(n, i)) {
        number++;
      }
    }
    return number;
  }

  public boolean getBit(int n, int i) {
    return (n & 1<<i) != 0;
  }
}
