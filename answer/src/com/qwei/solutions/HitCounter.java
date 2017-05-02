package com.qwei.solutions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qwei1 on 5/2/17.
 */
public class HitCounter {

  List<Integer> list;

  /** Initialize your data structure here. */
  public HitCounter() {
    this.list = new LinkedList<>();
  }

  /** Record a hit.
   @param timestamp - The current timestamp (in seconds granularity). */
  public void hit(int timestamp) {
    // store every hit in terms of time
    this.list.add(timestamp);
  }

  /** Return the number of hits in the past 5 minutes.
   @param timestamp - The current timestamp (in seconds granularity). */
  public int getHits(int timestamp) {
    int count=0;
    // poll all the timestamp which is not in the range
    for (int i=0; i<list.size(); i++) {
      if (timestamp - list.get(i) < 300) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    HitCounter h = new HitCounter();

    for (int i=1; i<=3; i++) {
      h.hit(1);
    }
    h.hit(300);
    h.getHits(300);
    h.hit(300);
    h.getHits(300);
    h.hit(301);
    System.out.println(h.getHits(301));
  }
}
