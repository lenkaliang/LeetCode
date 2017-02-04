package com.qwei.solutions;

import com.qwei.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the
 * nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {
  public static int minDepthRecursion(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = minDepthRecursion(root.left);
    int right = minDepthRecursion(root.right);

    // bug [1, 2]
    if (root.left == null) {
      return right + 1;
    } else if (root.right == null) {
      return left + 1;
    }

    return Math.min(left, right) + 1;
  }

  public static int minDepthIterative(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    int count = 1;
    while (!nodes.isEmpty()) {
      Queue<TreeNode> nextLevel = new LinkedList<>();
      while (!nodes.isEmpty()) {
        TreeNode node = nodes.poll();
        if (node.left == null && node.right == null) {
          return count;
        }

        if (node.left != null) {
          nextLevel.add(node.left);
        }
        if (node.right != null) {
          nextLevel.add(node.right);
        }
      }
      nodes.addAll(nextLevel);
      count++;
    }
    return count;
  }

}
