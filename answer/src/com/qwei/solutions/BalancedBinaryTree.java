package com.qwei.solutions;

import com.qwei.utils.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced. For this problem, a height-balanced
 * binary tree is defined as a binary tree in which the depth of the two subtrees of every node
 * never differ by more than 1.
 *
 * 需要一个求高度的function。对于每一个节点计算它是不是balanced。
 */
public class BalancedBinaryTree {
  public static boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    int left = getHeight(root.left);
    int right = getHeight(root.right);

    if (Math.abs(left-right) > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }

  public static int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
  }
}
