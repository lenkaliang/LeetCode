package com.qwei.solutions;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return
 * the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
  public static int searchInsert(int[] nums, int target) {
    if (nums == null) {
      return 0;
    }

    // As the array is sorted, do it with binary search.
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        if (mid + 1 == nums.length) {    // Corner case
          return mid + 1;
        }
        if (nums[mid+1] >= target) {
          return mid + 1;
        }
        low = mid + 1;
      } else {
        if (mid == 0) {                  // Corner case
          return mid;
        }
        if (nums[mid-1] < target) {
          return mid;
        }
        high = mid - 1;
      }
    }
    return 0;
  }
}
