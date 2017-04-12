package com.qwei.solutions;

import com.qwei.utils.TreeLinkNode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 * You may only use constant extra space.
 */
public class PopulateNextRightPointersInEachNodeII {
  public static void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }

    if (root.left != null) {      // left child is not null, set neighbor for it
      if (root.right != null) {
        root.left.next = root.right;
      } else {                    // if right child is null, use next to find left.next
        TreeLinkNode next = root.next;
        while (next != null && next.left == null && next.right == null) {
          next = next.next;
        }
        if (next == null) {  // rightmost node
          root.left.next = null;
        } else {
          if (next.left != null) {
            root.left.next = next.left;
          } else if (next.right != null) {
            root.left.next = next.right;
          }
        }
      }
    }

    if (root.right != null) {
      TreeLinkNode next = root.next;
      while (next != null && next.left == null && next.right == null) {
        next = next.next;
      }
      if (next == null) {
        root.right.next = null;
      } else {
        if (next.left != null) {
          root.right.next = next.left;
        } else if (next.right != null) {
          root.right.next = next.right;
        }
      }
    }

    // recursively set children
    connect(root.right);
    connect(root.left);

    // 当connect left child的时候，如果root没有right，那么就得keep looking for root的next。如果事先没有setup好，就会丢掉一些。所以recursion的时候总要先recurse right然后left child
  }
}
