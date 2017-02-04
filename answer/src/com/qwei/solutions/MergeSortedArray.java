package com.qwei.solutions;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
 * from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray {
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
      return;
    }

    // merge from largest number!!!!!
    int index1 = m-1, index2 = n-1;
    int index = m + n -1;
    while (index1 >=0 && index2 >= 0) {
      if (nums1[index1] > nums2[index2]) {
        nums1[index--] = nums1[index1--];
      } else {
        nums1[index--] = nums2[index2--];
      }
    }
    while (index2 >= 0) {
      nums1[index--] = nums2[index2--];
    }
  }
}
