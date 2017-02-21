package com.qwei.solutions;

import com.qwei.utils.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes
 * greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class PartitionList {
  public static ListNode partition(ListNode head, int  x) {
    // Pretty staightforward implementation problem
    if (head == null || head.next == null) {
      return head;
    }

    ListNode head1 = new ListNode(0);
    ListNode head2 = new ListNode(0);

    ListNode p = head;
    ListNode p1 = head1;
    ListNode p2 = head2;

    while (p != null) {
      ListNode next = p.next;
      if (p.val < x) {
        p1.next = p;
        p1 = p1.next;
        p1.next = null;
      } else {
        p2.next = p;
        p2 = p2.next;
        p2.next = null;
      }

      p = next;
    }

    p1.next = head2.next;
    return head1.next;
  }
}
