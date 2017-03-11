package com.qwei.solutions;

import com.qwei.utils.TreeNode;

/**
 * Look for the lowest common ancestor of two nodes in binary tree
 *
 * For the definition of common ancestor, please refer this link:
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?tab=Description
 *
 * For solution, please reference this video: https://www.youtube.com/watch?v=13m9ZCB8gjw
 *
 */
public class LowestCommonAncestor {
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
    // if root is null, return this null
    if (root == null) {
      return root;
    }

    // 如果碰到了要寻找的node，返回该node
    if (root == node1 || root == node2) {
      return root;
    }


    // Recursively go down to left and right
    TreeNode left = lowestCommonAncestor(root.left, node1, node2);
    TreeNode right = lowestCommonAncestor(root.right, node1, node2);

    // 如果分别从left和right找到了这两个点, 那么root便是要找的lowest
    if (left != null && right != null) {
      return root;
    }

    // 如果其中一个是null, means the non null one is the one you are looking for
    if (left != null) {
      return left;
    }

    if (right != null) {
      return right;
    }

    // did not find anything
    return null;
  }
}
