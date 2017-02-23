package com.qwei.solutions;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a
 * given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 */
public class SearchForARange {
  public static int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1,-1};
    }

    // O(logN) means binary search
    int start = 0, end = nums.length-1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        int i=mid, j=mid;
        while (nums[i] == target) {
          i--;
        }
        while (nums[j] == target) {
          j++;
        }

        return new int[]{i+1, j-1};
      }

      if (nums[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return new int[]{-1, -1};
  }

  public static int[] searchRange2(int[] nums, int target) {
    //To Do
    return null;
  }
}
