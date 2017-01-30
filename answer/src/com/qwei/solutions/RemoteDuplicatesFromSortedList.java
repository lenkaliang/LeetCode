package com.qwei.solutions;

import com.qwei.utils.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoteDuplicatesFromSortedList {
  public static ListNode removeDuplicate(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode first = head, second = head.next;
    while (second != null) {
      if (second.val == first.val) {
        second = second.next;
        if (second == null) {      // Corner case : [1,1]
          first.next = null;
        }
      } else {
        first.next = second;
        first = first.next;
        second = second.next;
      }
    }
    return head;
  }
}
