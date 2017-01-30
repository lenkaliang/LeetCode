package com.qwei.solutions;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the
 * largest sum = 6.
 *
 *
 */
public class MaximumSubarray {
  public static int maxSubarray1(int[] nums) { // O(n) method [DP]
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] maxSums = new int[nums.length]; // maxSums stores the max sum for each index which can
                                          // reach

    int maxSum = nums[0];
    maxSums[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      // either nums[i] is the biggest subarray for index i, or nums[i] + maxSums[i-1] (which is
      // previous biggest subarray)
      maxSums[i] = Math.max(nums[i], nums[i] + maxSums[i - 1]);
      maxSum = Math.max(maxSum, maxSums[i]);
    }

    return maxSum;
  }

  /**
   * Divide and conquer (Binary way)
   * There might be 3 cases generate the largest subarray
   * (1) Entirely in A[low,mid-1]
   * (2) Entirely in A[mid+1,high]
   * (3) Across mid
   */
  public static int maxSubarray2(int[] nums) { // Binary search
    if (nums == null || nums.length < 1) {
      return 0;
    }

    return helper(0, nums.length-1, nums[0], nums);
  }

  public static int helper(int left, int right, int currentMaxSum, int[] nums) {
    if (left > right) {
      return currentMaxSum;
    }

    int mid = (left+right)/2;

    int leftMax = helper(left, mid-1, currentMaxSum, nums);    // case (1)
    int rightMax = helper(mid+1, right, currentMaxSum, nums);   // case (2)

    // case (3) : By crossing the middle index, the sum must be leftToMiddle+middle+middleToRight
    int sum =0;

    int leftToMiddle = 0;
    for (int i=mid-1; i>=left; i--) {
      sum = sum+nums[i];
      leftToMiddle = Math.max(sum, leftToMiddle);
    }

    sum = 0;
    int middleToRight = 0;
    for (int i=mid+1; i<=right; i++) {
      sum = sum + nums[i];
      middleToRight = Math.max(sum, middleToRight);
    }

    int tempMax = Math.max(Math.max(leftMax, rightMax), currentMaxSum);
    int maxValue = Math.max(tempMax, leftToMiddle + nums[mid]+middleToRight);
    return maxValue;
  }
}
