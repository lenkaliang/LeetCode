package com.qwei.solutions;

import com.qwei.utils.DoubleLinkedListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the
 * following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 * otherwise return -1.
 *
 * put(key, value) - Set or insert the value if the key is not already present. When the cache
 * reached its capacity, it should invalidate the least recently used item before inserting a new
 * item.
 *
 * Follow up: Could you do both operations in O(1) time complexity?
 */
public class LRUCache {
  Map<Integer, DoubleLinkedListNode> map;
  DoubleLinkedListNode head, tail;
  int currLen, capacity;

  public LRUCache(int capacity) {
    this.map = new HashMap<>();
    currLen = 0;
    this.capacity = capacity;
  }

  public void setHead(DoubleLinkedListNode node) {
    if (node == null) {
      return;
    }

    if (head == null) {
      head = node;
      tail = node;
      return;
    }

    head.pre = node;
    node.next = head;
    head = node;
  }

  public void removeNode(DoubleLinkedListNode node) {
    if (node == null) {
      return;
    }

    DoubleLinkedListNode pre = node.pre;
    DoubleLinkedListNode next = node.next;

    if (node == head) {
      head = next;
    } else {
      pre.next = next;
    }

    if (node == tail) {
      tail = pre;
    } else {
      next.pre = pre;
    }
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    } else {
      DoubleLinkedListNode node = map.get(key);
      removeNode(node);
      setHead(node);
      return map.get(key).value;
    }
  }

  public void put(int key, int value) {
    if (!map.containsKey(key)) {
      DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
      map.put(key, newNode);
      if (currLen >= capacity) {
        setHead(newNode);
        DoubleLinkedListNode latest = this.tail;
        removeNode(tail);
        map.remove(latest.key);   // bug: map.remove(tail) tail has changed
      } else {
        setHead(newNode);
        currLen++;
      }
    } else {
      map.get(key).value = value;
      removeNode(map.get(key));
      setHead(map.get(key));
    }
  }
}
