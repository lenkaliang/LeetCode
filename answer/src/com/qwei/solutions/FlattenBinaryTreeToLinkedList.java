package com.qwei.solutions;

import com.qwei.utils.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * more detailed: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
  public static TreeNode lastNode = null;

  public static void flatten(TreeNode root) {
    if (root == null) {
      return;
    }

    if (lastNode != null) {
      lastNode.right = root;
      lastNode.left = null;   // remember to set null for left child
    }

    lastNode = root;

    TreeNode right = root.right;
    flatten(root.left);
    flatten(right);         // root.right will be changed in next loop, hence use temporary var right to store the right child
  }
}
