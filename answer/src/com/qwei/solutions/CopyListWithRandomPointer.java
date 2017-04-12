package com.qwei.solutions;

import com.qwei.utils.RandomListNode;

/**
 * A linked list is given such that each node contains an additional random pointer which could
 * point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * 第一遍循环：克隆每一个节点并且将该节点加在被克隆的节点之后。
 * 第二遍循环：根据被克隆的节点的random pointer来set克隆节点的random pointer。
 * 第三遍循环：分离新旧list
 */
public class CopyListWithRandomPointer {
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return head;
    }

    RandomListNode p = head;
    while (p != null) {            // 把新节点插入在链表中被克隆的点之后
      RandomListNode next = p.next;
      RandomListNode newNode = new RandomListNode(p.label);
      p.next = newNode;
      newNode.next = next;
      p = next;
    }

    p = head;
    while (p != null && p.next != null) {    // 设置每一个新节点的random指针
      RandomListNode random = p.random;
      if (random != null) {
        p.next.random = random.next;
      }
      p = p.next.next;
    }

    RandomListNode newHead = head.next;
    p = head;
    while (p.next != null) {    // 链接每一个新节点使之成为一个独立的List
      RandomListNode next = p.next;
      p.next = next.next;

      p = next;
    }
    return newHead;
  }
}
