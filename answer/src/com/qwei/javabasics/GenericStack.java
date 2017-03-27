package com.qwei.javabasics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The implementation of stack by using Java collection APIs
 */
public class GenericStack<E> {
  private List<E> values;

  public GenericStack() {
    // this.values = new ArrayList<>();
    // Think why here we are using LinkedList rather than an ArrayList
    this.values = new LinkedList<>();
  }

  public void push(E element) {
    values.add(0, element);
  }

  public E pop() {
    if (values.size() == 0) {
      return null;
    }
    return values.remove(0);
  }

  public GenericStack<E> putAll(List<? extends E> list) {
    if (list == null) {
      return this;
    }

    for (int i = 0; i < list.size(); i++) {
      this.values.add(list.get(i));
    }
    return this;
  }
}
