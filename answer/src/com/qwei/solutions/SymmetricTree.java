package com.qwei.solutions;

import com.qwei.utils.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 */
public class SymmetricTree {
  public static boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return helper(root.left, root.right);
  }

  public static boolean helper(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }

    if (left == null || right == null) {   // either one is null, false will be returned
      return false;
    }

    if (left.val != right.val) {
      return false;
    }

    return helper(left.left, right.right) && helper(left.right, right.left);
  }
}
