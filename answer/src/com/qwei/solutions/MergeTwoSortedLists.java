package com.qwei.solutions;

import com.qwei.utils.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Key point: two lists are sorted ones
 */
public class MergeTwoSortedLists {
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    // Utilities
    ListNode dummyHead = new ListNode(0);
    ListNode main = dummyHead;
    ListNode first = l1;
    ListNode second = l2;

    while (first != null && second != null) {
      if (first.val < second.val) {
        main.next = first;
        first = first.next;
      } else {
        main.next = second;
        second = second.next;
      }
      main = main.next;
    }

    ListNode temp = null;
    if (first == null) {
      temp = second;
    } else {
      temp = first;
    }

    while (temp != null) {
      main.next = temp;
      main = main.next;
      temp = temp.next;
    }

    return dummyHead.next;
  }
}
