package com.qwei.solutions;

import com.qwei.utils.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycleII {
  public static ListNode detectCyle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }

    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {          // remember how this is deciding if there is cycle in the list
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        break;
      }
    }

    if (fast == null || fast.next == null) {
      return null;
    }

    slow = head;

    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return fast;
  }
}
