package com.qwei.solutions;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same
 * color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
 * respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
  public static void sortColors(int[] nums) {
    if (nums == null || nums.length < 2) {
      return;
    }

    int red = 0, blue = nums.length-1;
    while (red < nums.length && nums[red] == 0) {
      red++;
    }
    while (blue >= 0 && nums[blue] == 2) {
      blue--;
    }

    int i = red;
    while (i < nums.length) {
      if (nums[i] == 0 && i > red) {
        int temp = nums[i];
        nums[red++] = nums[i];
        nums[i] = temp;
        continue;
      }

      if (nums[i] == 2 && i < blue) {
        int temp = nums[i];
        nums[blue--] = nums[i];
        nums[i] = temp;
        continue;
      }
      i++;
    }
  }

  /**
   * For the above code, understand that red is used to track the last 0, blue is used to track
   * the first 2. And i is used as cursor of replacing the 0 and 2 in middle of red and blue. Thus,
   * replace will happen only when nums[i] == 0  && i > red || nums[i] == 2 && i < blue
   */
}
