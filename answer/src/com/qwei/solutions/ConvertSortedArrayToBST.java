package com.qwei.solutions;



import com.qwei.utils.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Understand that, a BST, the left child is less than or equal to root, the right child is bigger
 * than or equal to the root.
 * For a sorted array, the only case is this array is from inorder traversal
 *
 * Note: this problem is asking for height balanced BST. So, there will be only one possibility.
 */
public class ConvertSortedArrayToBST {
  public static TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }

    return helper(0, nums.length-1, nums);
  }

  public static TreeNode helper(int start, int end, int[] nums) {
    if (start > end) {      // There is chance start will never equals end, hence if using start == end as return condition, it will run stackoverflow.
      return null;
    }

    int m = (start + end) / 2;
    TreeNode root = new TreeNode(nums[m]);
    TreeNode leftTree = helper(start, m-1, nums); // construct left subtree
    TreeNode rightTree = helper(m+1, end, nums); // construct right subtree
    root.left = leftTree;
    root.right = rightTree;

    return root;
  }
}
