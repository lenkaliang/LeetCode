package com.qwei.solutions;

import com.qwei.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
 * all the values along the path equals the given sum.
 *
 * For example, please take a look at this: https://leetcode.com/problems/path-sum/
 */
public class PathSum {
  public static boolean hasSumBFS(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    Queue<TreeNode> nodes = new LinkedList<TreeNode>();
    Queue<Integer> values = new LinkedList<Integer>();
    nodes.add(root);
    values.add(root.val);
    while (!nodes.isEmpty()) {
      Queue<TreeNode> nextLevelNodes = new LinkedList<TreeNode>();
      Queue<Integer> nextLevelValues = new LinkedList<Integer>();
      while (!nodes.isEmpty()) {
        TreeNode node = nodes.poll();
        int value = values.poll();
        if (value == sum && node.left == null && node.right == null) {
          return true;
        }

        if (node.left != null) {
          nextLevelNodes.add(node.left);
          nextLevelValues.add(value + node.left.val);
        }

        if (node.right != null) {
          nextLevelNodes.add(node.right);
          nextLevelValues.add(value + node.right.val);
        }
      }
      nodes = nextLevelNodes;
      values = nextLevelValues;
    }
    return false;
  }

  public static boolean hasSumDFS(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    Stack<TreeNode> nodes = new Stack<TreeNode>();
    Stack<Integer> values = new Stack<Integer>();

    nodes.add(root);
    values.add(root.val);

    while (!nodes.isEmpty()) {
      TreeNode node = nodes.pop();
      int value = values.pop();

      if (value == sum && node.left == null && node.right == null) {
        return true;
      }
      if (node.right != null) {
        nodes.push(node.right);
        values.push(value + node.right.val);
      }
      if (node.left != null) {
        nodes.push(node.left);
        values.push(value + node.left.val);
      }
    }
    return false;
  }
}
