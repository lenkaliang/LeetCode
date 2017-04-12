package com.qwei.solutions;

import com.qwei.utils.ListNode;
import com.qwei.utils.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * Any idea: http://bangbingsyb.blogspot.com/2014/11/leetcode-convert-sorted-list-to-binary.html
 */
public class ConvertedSortedListToBinarySearchTree {
  static ListNode h = null;
  public static TreeNode convert(ListNode head) {
    if (head == null) {
      return null;
    }

    int len = 0;
    ListNode cur = head;
    while (cur != null) {
      len++;
      cur = cur.next;
    }

    h = head;
    return helper(0, len-1);
  }

  public static TreeNode helper(int start, int end) {
    if (start > end) {
      return null;
    }

    int mid = (start + end) / 2;
    TreeNode left = helper(start, mid-1);
    TreeNode root = new TreeNode(h.val);
    root.left = left;
    h = h.next;

    TreeNode right = helper(mid+1, end);
    root.right = right;
    return root;
  }
}
