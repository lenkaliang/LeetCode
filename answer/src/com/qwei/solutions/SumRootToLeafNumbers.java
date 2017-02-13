package com.qwei.solutions;

import com.qwei.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a
 * number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {
  public static int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }

    // this needs preorder traversal (DFS)
    Stack<TreeNode> nodes = new Stack<>();
    Stack<Integer> values = new Stack<>();
    nodes.push(root);
    values.push(root.val);

    int sum = 0;
    while (!nodes.isEmpty()) {
      TreeNode node = nodes.pop();
      int value = values.pop();

      if (node.left == null && node.right == null) {
        sum += value;
      }

      if (node.right != null) {
        nodes.push(node.right);
        values.push(value * 10 + node.right.val);
      }

      if (node.left != null) {
        nodes.push(node.left);
        values.push(value * 10 + node.left.val);
      }
    }
    return sum;
  }

  public static int sumNumbersBFS(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> nodes = new LinkedList<>();
    Queue<Integer> values = new LinkedList<>();

    nodes.add(root);
    values.add(root.val);

    int sum = 0;
    while (!nodes.isEmpty()) {
      Queue<TreeNode> eachLevelNodes = new LinkedList<>();
      Queue<Integer> eachLevelValues = new LinkedList<>();
      while (!nodes.isEmpty()) {
        TreeNode node = nodes.poll();
        int value = values.poll();
        if (node.left == null && node.right == null) {
          sum = sum + value;
        }

        if (node.left != null) {
          eachLevelNodes.add(node.left);
          values.add(value * 10 + node.left.val);
        }

        if (node.right != null) {
          eachLevelNodes.add(node.right);
          values.add(value * 10 + node.right.val);
        }
      }
      nodes.addAll(eachLevelNodes);
      values.addAll(eachLevelValues);
    }
    return sum;
  }
}
