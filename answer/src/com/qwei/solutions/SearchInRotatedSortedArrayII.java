package com.qwei.solutions;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Write a function to determine if a given target is in the array.
 */
public class SearchInRotatedSortedArrayII {
  public static boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    int start = 0, end = nums.length-1;

    // Always focus on the sorted side
    while (start <= end) {
      int mid = (start + end)/2;
      if (nums[mid] == target) {
        return true;
      }

      // nums[mid] != target
      if (nums[start] < nums[mid]) {        // start to mid is sorted
        if (nums[start] <= target && target < nums[mid]) {     // always focus on the sorted part
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else if (nums[start] > nums[mid]) { // mid to end is sorted
        if (nums[mid] < target && target <= nums[end]) {       // alwasy focus on the sorted part
          start = mid + 1;
        } else {
          end = mid -1;
        }
      } else {           // nums[start] == nums[mid]
        start++;
      }
    }

    return false;
  }
}
