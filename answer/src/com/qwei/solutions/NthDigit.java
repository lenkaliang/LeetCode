package com.qwei.solutions;

/**
 * This is a really good problem: https://leetcode.com/problems/nth-digit/#/description
 *
 * A good analysis goes here: http://www.cnblogs.com/grandyang/p/5891871.html
 * 这道题目与"divide two integers" 很相似，可以结合起来看。关键点在于发现1-9, 10-99, 100-999的规律。这样可以
 * 大大节省时间。
 */
public class NthDigit {
  public int nthDigit(int n) {
    long start=1, count=9, len= 1, temp=(long)n;

    while (temp > count * len) {
      temp = temp - count * len;
      count = count * 10;
      start = start * 10;
      len++;
    }

    long number = start + (temp-1)/len;
    long index = (temp-1)%len;
    return String.valueOf(number).charAt((int)index)-'0';
  }
}
