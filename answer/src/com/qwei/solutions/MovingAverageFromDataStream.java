package com.qwei.solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 * 讲解：http://www.cnblogs.com/grandyang/p/5450001.html
 */
public class MovingAverageFromDataStream {
  private Queue<Integer> queue;
  private int maxSize;
  private int currSize;
  private int sum;

  /** Initialize your data structure here. */
  public MovingAverageFromDataStream(int size) {
    this.queue = new LinkedList<>();
    this.maxSize = size;
    currSize = 0;
  }

  public double next(int val) {
    queue.add(val);
    sum += val;
    currSize++;
    if (currSize > maxSize) {
      int removed = queue.poll();
      currSize--;
      sum -= removed;
    }
    return (double)sum / 3;
  }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
