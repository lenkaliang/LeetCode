package com.qwei.solutions;

import com.qwei.utils.TreeNode;

/**
 * The diameter of a binary tree means the longest path between node of this binary tree.
 * This longest path might pass / not pass the root.
 *
 * 这个题关键是要了解如何calculate max depth.
 * pass每一个nodelongest path = MaxDepth(node.left) + MaxDepth(node.right)
 */
public class DiameterOfBinaryTree {
  int max = 0;
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    // Need to go over all the node
    int leftMaxDepth = maxDepth(root.left);
    int rightMaxDepth = maxDepth(root.right);

    max = Math.max(max, leftMaxDepth+rightMaxDepth);
    diameterOfBinaryTree(root.left);
    diameterOfBinaryTree(root.right);

    return max;
  }

  public int maxDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = maxDepth(node.left);
    int right = maxDepth(node.right);

    return Math.max(left, right) + 1;
  }
}
