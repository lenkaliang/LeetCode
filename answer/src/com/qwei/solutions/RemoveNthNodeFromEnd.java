package com.qwei.solutions;

import com.qwei.utils.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * i.e. Given linked list: 1->2->3->4->5, and n = 2. After removing the second node from the end,
 * the linked list becomes 1->2->3->5.
 *
 * Algorithms: Move one pointer n step to point the Nth node from the beginning.
 */
public class RemoveNthNodeFromEnd {
  public static ListNode removeNthNodeFromEndOfList(ListNode head, int n) {
    if (head == null) {
      return head;
    }

    int index = 1;
    ListNode first = head;
    while (first.next != null && index < n) {     // when index == n, the frist node is n nodes away from the beginning
      first = first.next;
      index++;
    }

    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode second = head;
    ListNode preSecond = dummyHead;

    while(first != null) {
      if (first.next == null) {        // the last node
        preSecond.next = second.next;
        break;
      }

      first = first.next;
      second = second.next;
      preSecond = preSecond.next;
    }
    return dummyHead.next;
  }
}
