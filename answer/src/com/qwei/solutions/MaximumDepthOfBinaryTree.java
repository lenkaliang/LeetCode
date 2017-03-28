package com.qwei.solutions;

import com.qwei.utils.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = maxDepth(root.left) + 1; // left max depth + current level
    int right = maxDepth(root.right) + 1; // right max depth + current level

    return Math.max(left, right);
  }
}
