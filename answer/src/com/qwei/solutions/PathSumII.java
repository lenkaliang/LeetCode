package com.qwei.solutions;

import com.qwei.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given
 * sum.
 *
 */
public class PathSumII {
  public static List<List<Integer>> findPath(TreeNode root, int sum) {
    List<List<Integer>> list = new ArrayList<>();

    if (root == null) {
      return list;
    }

    List<TreeNode> solution = new ArrayList<>();
    helper(list, solution, root, sum);
    return list;
  }

  public static void helper(List<List<Integer>> list, List<TreeNode> solution, TreeNode node,
      int sum) {
    if (node == null) {                         // this check is neccessary.
      return;
    }

    solution.add(node);
    sum = sum - node.val;

    if (node.left == null && node.right == null) {
      if (sum == 0) {
        List<Integer> path = new ArrayList<>();
        for (TreeNode eachNode: solution) {
          path.add(eachNode.val);
        }
        list.add(path);
      }
      solution.remove(solution.size()-1);
      return;
    }

    helper(list, solution, node.left, sum);
    helper(list, solution, node.right, sum);
    solution.remove(solution.size()-1);
    return;
  }
}
