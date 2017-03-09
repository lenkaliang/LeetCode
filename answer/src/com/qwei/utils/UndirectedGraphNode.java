package com.qwei.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiwei on 3/8/17.
 */
public class UndirectedGraphNode {
  public int label;
  public List<UndirectedGraphNode> neighbors;
  public UndirectedGraphNode(int x) {
    this.label = x;
    neighbors = new ArrayList<>();
  }
}
