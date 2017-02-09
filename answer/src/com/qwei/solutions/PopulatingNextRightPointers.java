package com.qwei.solutions;

import com.qwei.utils.TreeLinkNode;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node, the
 * next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * You may only use constant extra space. You may assume that it is a perfect binary tree (ie, all
 * leaves are at the same level, and every parent has two children).
 *
 *
 */
public class PopulatingNextRightPointers {
  public static void connect(TreeLinkNode root) {
    if (root == null) {
      return;
    }
    root.next = null;
    helper(root);
  }

  public static void helper(TreeLinkNode node) {
    if (node == null) {
      return;
    }

    if (node.left != null) {    // the leftmost node
      node.left.next = node.right;  // if node.left != null, then node.right != null is true
      if (node.next != null) {      // make sure the node is not rightmost node in parent level
        node.right.next = node.next.left;
      }
    }

    helper(node.left);
    helper(node.right);
  }
}
