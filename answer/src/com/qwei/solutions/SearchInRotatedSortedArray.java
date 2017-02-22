package com.qwei.solutions;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
  public static int serach(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int start = 0, end = nums.length-1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        return mid;
      }

      if (start == mid) {         // start == mid does not indicates that mid == end
        start =  mid + 1;
        continue;
      }

      if (mid == end) {
        end = mid - 1;
        continue;
      }

      if (nums[start] < nums[mid]) {
        if (nums[start] <= target && target < nums[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (nums[mid] < target && target <= nums[mid]) {
          start = mid + 1;
        } else {
          end = mid -1;
        }
      }
    }

    return -1;
  }
}
