package com.qwei.javabasics;

/**
 * 通过这个class明白hashcode. (http://blog.csdn.net/fenglibing/article/details/8905007)
 *
 * 1. hashCode的存在主要是用于查找的快捷性，如Hashtable，HashMap等，hashCode是用来在反映存储结构中确定对象的存储地址的；
 * 2. 如果两个对象相同(equals() return true)，那么他们的hashcode值一定相同。如果两个对象hashcode相同但是他们却不一定相等，需要用equals方法做比较；
 */
public class UnderstandHashcode {
  private int i;

  public UnderstandHashcode(int i) {
    this.i = i;
  }

  public int hashcode() {
    return i % 10;
  }

  public boolean equals(Object object) {
    if (object == null) {
      return false;
    }
    if (object == this) {
      return true;
    }
    if (object instanceof UnderstandHashcode) {
      UnderstandHashcode o = (UnderstandHashcode)object;
      return o.i == this.i;
    }
    return false;
  }

  public static void main(String[] args) {
    UnderstandHashcode u1 = new UnderstandHashcode(1);
    UnderstandHashcode u2 = new UnderstandHashcode(1);

    System.out.println(u1.equals(u2));  // if comment equals(), this prints false; else prints true;
  }
}
