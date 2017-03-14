package com.qwei.utils;

import java.util.List;

/**
 * Created by qwei1 on 3/12/17.
 */
public interface NestedInteger {
  /**
   * @return true if this NestedInteger holds a single integer, rathre than a list.
   */
  public boolean isInteger();

  /**
   * @return the single integer that this NestedInteger holds, if it holds a single integer.
   * Return null if this NestedInteger holds a nested list
   */
  public Integer getInteger();

  /**
   * @return the nested list that this NestedInteger holds, if it holds a nested list
   * Return null if this NestedInteger holds a single integer
   */
  public List<NestedInteger> getList();
}
