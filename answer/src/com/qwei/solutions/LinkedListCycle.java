package com.qwei.solutions;

import com.qwei.utils.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it. Follow up: Can you solve it without using
 * extra space?
 */
public class LinkedListCycle {
  public static boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    ListNode fast = head.next;
    ListNode slow = head;

    while (fast.next != null && fast.next.next != null) {
      if (fast == slow || fast.next == slow) {
        return true;
      }
      fast = fast.next.next;
      slow = slow.next;
    }

    return false;
  }
}
