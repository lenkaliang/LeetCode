package com.qwei.solutions;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 *
 * For example, Given sorted array nums = [1,1,1,2,2,3], Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave
 * beyond the new length.
 */
public class RemoveDuplicatedFromSortedArrayII {
  public static int removeDuplicates(int[] nums) {
    if (nums == null) {
      return 0;
    }

    if (nums.length < 3) {
      return nums.length;
    }

    int p = 1, l = 2;
    while (l < nums.length) {
      if (nums[p] == nums[l]) {
        if (nums[p] == nums[p-1]) {
          l++;
        } else {
          nums[++p] = nums[l++];
        }
      } else {
        nums[++p] = nums[l++];
      }
    }
    return p+1;
  }
}
