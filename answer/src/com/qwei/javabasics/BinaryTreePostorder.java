package com.qwei.javabasics;

import com.qwei.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * post order: left substree, right subtree, root
 */
public class BinaryTreePostorder {
  public static List<TreeNode> postorderTraverse(TreeNode root) {
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
    helper(list, root.right);
    list.add(root);
  }
}
