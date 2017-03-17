package com.qwei.solutions;

import com.qwei.utils.TreeNode;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between
 * values of any two nodes.
 *
 * A good problem to understand about two pointer inorder traversal
 */
public class MinimumAbsoluteDiffereceInBST {
  int min = Integer.MAX_VALUE;
  int prev = -1;

  public int getMinimumDifference(TreeNode root) {
    // this is a binary search tree, so the inorder traversal is needed.
    if (root == null) {
      return min;
    }

    getMinimumDifference(root.left);

    if (prev != -1) {
      min = Math.min(min, root.val - prev);
    }
    prev = root.val;

    getMinimumDifference(root.right);

    return min;
  }
}
