package com.qwei.solutions;

import com.qwei.utils.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
 * numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummyHead = new ListNode(head.val + 1);
    dummyHead.next = head;

    ListNode newHead = new ListNode(0);
    ListNode p = newHead;

    ListNode pre = dummyHead, curr = head;
    while (curr.next != null) {
      if (curr.val != pre.val && curr.val != curr.next.val) {
        p.next = curr;
        p = p.next;
      }
      pre = pre.next;
      curr = curr.next;
    }

    if (pre.val != curr.val) {
      p.next = curr;
    } else {
      p.next = null;
    }

    return newHead.next;
  }
}
