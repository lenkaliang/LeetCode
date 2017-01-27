package com.qwei.javabasics;

import com.qwei.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * In order traversal: left subtree, root, right substree
 */
public class BinaryTreeInorder {
  public static List<TreeNode> inorderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<TreeNode>();
    }

    List<TreeNode> list = new ArrayList<TreeNode>();
    helper(list, root);
    return list;
  }

  public static void helper(List<TreeNode> list, TreeNode root) {
    if (root == null) {
      return;
    }

    helper(list, root.left);
    list.add(root);
    helper(list, root.right);
  }
}
