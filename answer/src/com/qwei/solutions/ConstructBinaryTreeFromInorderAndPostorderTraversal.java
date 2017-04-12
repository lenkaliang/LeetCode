package com.qwei.solutions;

import com.qwei.utils.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * You may assume that duplicates do not exist in the tree.
 *
 * 牢记：
 * preorder = root, left, right;
 * inorder = left, root, right;
 * postorder = left, right, root;
 *
 * 递归函数：helper(int[] inorder, int[] postorder, int inStart, int inEnd, int posStart, int posEnd)
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
  public static TreeNode build(int[] inorder, int[] postorder) {
    if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
      return null;
    }

    return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
  }

  public static TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) {
      return null;
    }

    TreeNode root = new TreeNode(postorder[postEnd]);

    int leftSubTreeEnd = 0, rightSubTreeStart = 0;
    for (int i = inStart; i<=inEnd; i++) {
      if (inorder[i] == root.val) {
        leftSubTreeEnd = i-1;
        rightSubTreeStart = i + 1;
        break;
      }
    }

    int leftLen = leftSubTreeEnd - inStart;
    int rightLen = inEnd - rightSubTreeStart;

    TreeNode left = helper(inorder, postorder, inStart, leftSubTreeEnd, postStart, postStart + leftLen);
    TreeNode right = helper(inorder, postorder, rightSubTreeStart, inEnd,postEnd-1-rightLen, postEnd-1);

    root.left = left;
    root.right = right;

    return root;
  }
}
