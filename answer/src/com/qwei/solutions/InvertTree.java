package com.qwei.solutions;

import com.qwei.utils.TreeNode;

/**
 * Description goes here:
 * https://leetcode.com/problems/invert-binary-tree/#/description
 *
 * 对于每一个节点，recursively将它的左右节点互换。
 */
public class InvertTree {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    invertTree(root.left);
    invertTree(root.right);
    return root;
  }
}
