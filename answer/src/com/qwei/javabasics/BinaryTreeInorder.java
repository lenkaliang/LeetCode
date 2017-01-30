package com.qwei.javabasics;

import com.qwei.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

  /**
   * inorder traversal binary search tree with iterative way
   * DFS in iterative
   */
  public static List<TreeNode> inorderTraversalIterative(TreeNode root) {
    if (root == null) {
      return new ArrayList<TreeNode>();
    }

    List<TreeNode> list = new ArrayList<TreeNode>();
    Stack<TreeNode> stack = new Stack<TreeNode>();

    TreeNode node = root;
    while (node != null) {
      stack.push(node);
      node = node.left;
    }

    while (!stack.isEmpty()) {
      node = stack.pop();
      list.add(node);
      if (node.right != null) {
        node = node.right;
        while (node != null) {
          stack.push(node.left);
          node = node.left;
        }
      }
    }
    return list;
  }
}
