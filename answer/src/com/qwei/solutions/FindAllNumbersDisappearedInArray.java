package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does
 * not count as extra space.
 *
 * Example:
 * Input: [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 *
 */
public class FindAllNumbersDisappearedInArray {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    for (int i=0; i<nums.length; i++) {
      // 通过这个，如果每一个数只出现一次的话，他们都将会被标记为对应的负数
      // 但是有的数会出现两次，所以，经过第一个for循环，所有没有被标记为负数的index就是要寻找的位置
      // 例如上例经过此轮循环数组会变成 [-4,-3,-2,-7,8,2,-3,-1]
      // 8之所以没有变成-8是因为原始数组中没有5，而第二个2没有变成-2是因为原始数组中没有6
      nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
    }
    List<Integer> list = new ArrayList<>();
    for (int i=0; i<nums.length; i++) {
      if (nums[i] > 0) {
        list.add(i+1);
      }
    }
    return list;
  }
}
