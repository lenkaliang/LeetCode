package com.qwei.javabasics;

import com.qwei.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

  /**
   * Post order traverse a tree with iterative method This needs better understanding
   *
   * Comments:
   */
  public static List<TreeNode> postorderTraverseIterative(TreeNode root) {
    List<TreeNode> list = new ArrayList<TreeNode>();
    TreeNode pre = null;
    TreeNode curr = root;

    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);

    while (!stack.isEmpty()) {
      curr = stack.peek();
      if (pre == null || pre.left == curr || pre.right == curr) {
        if (curr.left != null) {
          stack.push(curr.left);
        } else if (curr.right != null) {
          stack.push(curr.right);
        }
      } else if (curr.left == pre) {
        if (curr.right != null) {
          stack.push(curr.right);
        }
      } else {
        list.add(stack.pop());
      }
      pre = curr;
    }
    return list;
  }
}
