package com.qwei.solutions;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and
 * return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array nums = [1,1,2], Your function should return length = 2, with the
 * first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond
 * the new length.
 */
public class RemoveDuplicatesFromSortedArray {
  public static int remoteDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int index1 = 0, index2 = 1;
    while (index2 < nums.length) {
      if (nums[index1] == nums[index2]) {
        index2++;
      } else {
        nums[index1 + 1] = nums[index2];
        index1++;
        index2++;
      }
    }
    return index1+1;
  }
}
