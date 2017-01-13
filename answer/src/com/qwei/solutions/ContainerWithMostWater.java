package com.qwei.solutions;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i,
 * ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains
 * the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {
  public static int maxArea(int[] heights) {
    if (heights == null || heights.length < 2) {
      return 0;
    }

    int left = 0;
    int right = heights.length - 1;
    int max = 0;

    while (left < right) {
      int currentArea = (right - left) * Math.min(heights[left], heights[right]);
      max = Math.max(max, currentArea);

      if (heights[left] < heights[right]) {
        left++;
      } else {
        right--;
      }
    }

    return max;
  }
}
