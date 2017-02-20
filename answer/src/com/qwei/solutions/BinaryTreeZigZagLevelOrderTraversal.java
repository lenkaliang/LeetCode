package com.qwei.solutions;

import com.qwei.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class BinaryTreeZigZagLevelOrderTraversal {
  public static List<List<Integer>> traversal(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    boolean toReverse = false;
    while (!stack.isEmpty()) {
      Stack<TreeNode> nextLevel = new Stack<>();
      List<Integer> currLevel = new ArrayList<>();
      while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        currLevel.add(node.val);

        if (!toReverse) {
          if (node.left != null) {
            nextLevel.push(node.left);
          }

          if (node.right != null) {
            nextLevel.push(node.right);
          }
        } else {
          if (node.right != null) {
            nextLevel.push(node.right);
          }

          if (node.left != null) {
            nextLevel.push(node.left);
          }
        }
      }
      list.add(currLevel);
      stack = nextLevel;
      toReverse = !toReverse;
    }
    return list;
  }
}
