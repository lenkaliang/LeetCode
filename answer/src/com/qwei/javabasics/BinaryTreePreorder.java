package com.qwei.javabasics;

;
import com.qwei.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The visit order: Root, left subtree, right subtree
 */
public class BinaryTreePreorder {
  public static List<TreeNode> preorderTraverse(TreeNode root) {
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
    list.add(root);
    helper(list, root.left);
    helper(list, root.right);
  }

  /**
   * Preorder traverse a binary tree with iterative way
   *
   * Depth first search
   */
  public static List<TreeNode> preorderTraverseIterative(TreeNode root) {
    if (root == null) {
      return new ArrayList<TreeNode>();
    }

    List<TreeNode> list = new ArrayList<TreeNode>();
    Stack<TreeNode> stack = new Stack<TreeNode>();

    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      list.add(node);
      if (node.right != null) {  // Push right first
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
    return list;
  }
}
