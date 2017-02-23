package com.qwei.solutions;

import com.qwei.utils.ListNode;
import com.qwei.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store
 * values 1...n.
 *
 *
 */
public class UniqueBinarySearchTreesII {
  public static List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<TreeNode>();
    }
    return helper(0, n);
  }

  public static List<TreeNode> helper(int start, int end) {
    List<TreeNode> list = new ArrayList<>();
    if (start > end) {
      list.add(null);
      return list;
    }

    for (int i=start; i<=end; i++) {
      List<TreeNode> leftSubTrees = helper(start, i-1);
      List<TreeNode> rightSubTrees = helper(i+1, end);

      for (TreeNode left: leftSubTrees) {
        for (TreeNode right: rightSubTrees) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;

          list.add(root);
        }
      }
    }
    return list;
  }
}
