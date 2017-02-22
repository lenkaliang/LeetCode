package com.qwei.solutions;

import com.qwei.utils.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
  public static TreeNode build(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
      return null;
    }

    return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
  }

  public static TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[preStart]);

    int leftSubEnd = 0, rightSubStart = 0;
    for (int i=inStart; i<=inEnd; i++) {
      if (inorder[i] == root.val) {
        leftSubEnd = i-1;
        rightSubStart = i+1;
        break;
      }
    }

    int leftLen = leftSubEnd - inStart;
    int rightLen = inEnd - rightSubStart;

    TreeNode left = helper(preorder, inorder, preStart + 1, preStart + 1 + leftLen, inStart, leftSubEnd);
    TreeNode right = helper(preorder, inorder, preEnd - rightLen, preEnd, rightSubStart, inEnd);

    root.left = left;
    root.right = right;

    return root;
  }
}
