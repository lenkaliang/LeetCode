package com.qwei.solutions;

import com.qwei.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Level order traverse a binary tree
 */
public class BinaryTreeLevelOrderTraversal {
  public static List<List<TreeNode>> levelOrderTraverse(TreeNode root) {
    if (root == null) {
      return new ArrayList<List<TreeNode>>();
    }

    List<List<TreeNode>> traveralList = new ArrayList<List<TreeNode>>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>(); // it stores the tree nodes of each level
    queue.offer(root);

    while (!queue.isEmpty()) {
      Queue<TreeNode> tempQueue = new LinkedList<TreeNode>();
      List<TreeNode> levelList = new ArrayList<TreeNode>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        levelList.add(node);

        if (node.left != null) {
          tempQueue.add(node.left);
        }
        if (node.right != null) {
          tempQueue.add(node.right);
        }
        if (queue.isEmpty()) {   // the current level is done
          traveralList.add(levelList);
        }
      }
      queue.addAll(tempQueue);   // bug
    }
    return traveralList;
  }

}
