package com.qwei.solutions;

import com.qwei.utils.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3. Your algorithm should
 * use only constant space. You may not modify the values in the list, only nodes itself can be
 * changed.
 */
public class SwapNodesInPairs {
  public static ListNode swapNodes(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;

    ListNode pre = dummyHead, first = head, second = first.next;

    while (first != null && second != null) {
      ListNode tmp = second.next;
      pre.next = second;
      first.next = tmp;
      second.next = first;

      pre = first;
      first = pre.next;
      if (first != null) {
        second = first.next;
      }
    }

    return dummyHead.next;
  }
}
