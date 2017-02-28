package com.qwei.utils;

import java.util.Comparator;

/**
 * Created by qwei1 on 2/28/17.
 */
public class Interval implements Comparable {
  public int start;
  public int end;

  public Interval() {
    this.start = 0;
    this.end = 0;
  }

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }


  @Override
  public int compareTo(Object o) {
    if (!(o instanceof Interval)) {
      // Do something
    }

    return this.start - ((Interval)o).start;
  }
}
