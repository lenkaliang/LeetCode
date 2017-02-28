package com.qwei.solutions;

import com.qwei.utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
  public static List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.size() <= 1) {
      return intervals;
    }

    Collections.sort(intervals);

    List<Interval> list = new ArrayList<>();
    int start = intervals.get(0).start, end = intervals.get(0).end;

    for (int i=1; i<intervals.size(); i++) {
      Interval curr = intervals.get(i);

      if (curr.start <= end) {
        end = Math.max(end, curr.end);
      } else {
        Interval combined = new Interval(start, end);
        list.add(combined);

        start = curr.start;
        end = curr.end;
      }
    }

    Interval last = new Interval(start, end);
    list.add(last);
    return list;
  }
}
