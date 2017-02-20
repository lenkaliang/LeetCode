package com.qwei.solutions;

import com.qwei.utils.ListNode;

/**
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
  public static ListNode insertionSort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode p = head.next;
    head.next = null; // to avoid infinite loop

    while (p != null) {
      ListNode next = p.next;

      if (p.val < head.val) { // p should go to head, remember to update head
        p.next = head;
        head = p;
        p = next;
        continue;
      }

      ListNode c = head;
      while (c.next != null) { // Find the right spot in between the new list;
        if (c.val <= p.val && p.val < c.next.val) {
          ListNode temp = c.next;
          c.next = p;
          p.next = temp;
          break;
        }
        c = c.next;
      }

      if (c.next == null) { // p should go ot the end, remembr to update p.next (L40)
        c.next = p;
        p.next = null;
      }

      p = next;
    }

    return head;
  }
}
