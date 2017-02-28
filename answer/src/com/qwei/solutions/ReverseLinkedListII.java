package com.qwei.solutions;

import com.qwei.utils.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {
  public static ListNode reverse(ListNode head, int m, int n) {
    if (head == null || head.next == null || m == n) {
      return head;
    }

    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;

    ListNode preStart = dummyHead;
    ListNode start = head, end = head;

    int count = 1;

    while (count < m) {
      count++;
      preStart = preStart.next;
      start = start.next;
      end = end.next;
    } // start is on mth node

    while (count < n) {
      count++;
      end = end.next;
    }  // end is on nth node
    ListNode afterEnd = end.next;

    ListNode node = reverseList(start, end);
    preStart.next = node;
    start.next = afterEnd;

    return dummyHead.next;
  }


  public static ListNode reverseList(ListNode head, ListNode end) {
    ListNode p = head, q = head.next;
    end.next = null;
    head.next = null;

    while (q != null) {
      ListNode temp = q.next;
      q.next = p;
      p = q;
      q = temp;
    }

    return end;
  }
}
