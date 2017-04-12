package com.qwei.solutions;

import com.qwei.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qwei1 on 4/10/17.
 */
public class ClosetBinarySearchTreeValue {
  double theDiff;
  int theClosest;

  // recursion
  public int closestValue(TreeNode root, double target) {
    if (root == null) {
      return theClosest;
    }
    this.theDiff = Math.abs(root.val - target);
    this.theClosest = root.val;

    helper(root.left, target);
    helper(root.right, target);
    return theClosest;
  }

  public void helper(TreeNode node, double target) {
    if (node == null) {
      return;
    }
    if (node.val == target) {
      theClosest = node.val;
      return;
    }

    double currDiff = Math.abs(node.val - target);
    if (currDiff < theDiff) {
      theDiff = currDiff;
      theClosest = node.val;
    }

    helper(node.left, target);
    helper(node.right, target);
  }

  // Iterative
  public int closestValue1(TreeNode root, double target) {
    List<Integer> list = new ArrayList<>();

    getList(root, list);

    double diff = Math.abs(root.val - target);
    int closest = root.val;

    for (int i : list) {
      if (diff > Math.abs(i - target)) {
        diff = Math.abs(i - target);
        closest = i;
      }
    }

    return closest;
  }

  public void getList(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    getList(root.left, list);
    list.add(root.val);
    getList(root.right, list);
  }


  // The best solution: Binary search
  public int closestValueBinarySearch(TreeNode root, double target) {
    int closest = root.val;
    double diff = Math.abs(root.val - target);

    TreeNode p = root;
    while (p != null) {
      if (p.val == target) {
        return p.val;
      }

      double newDiff = Math.abs(p.val - target);
      if (newDiff < diff) {
        diff = newDiff;
        closest = p.val;
      }

      if (target < p.val) {        // 不断的去逼近最接近的值
        p = p.left;                // 因为之前走过的每一个点都记录了diff和closest，所以不会丢掉点
      } else {
        p = p.right;
      }
    }

    return closest;
  }
}
