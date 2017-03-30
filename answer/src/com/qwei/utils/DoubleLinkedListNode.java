package com.qwei.utils;

/**
 * Created by qwei1 on 3/29/17.
 */
public class DoubleLinkedListNode {
  public Integer key, value;
  public DoubleLinkedListNode pre;
  public DoubleLinkedListNode next;

  public DoubleLinkedListNode(int key, int value) {
    this.key = key;
    this.value = value;
  }
}
