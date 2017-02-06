package com.qwei.solutions;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * Good explanation: http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html [DP]
 */
public class UniqueBSTs {
  public static int numTrees(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    int sum = 0;
    int i = 0, j = n - 1;
    while (i <= n - 1 && j >= 0) {
      sum += numTrees(i) * numTrees(j);
      i++;
      j--;
    }
    return sum;
  }

  // This works, but exceeds limited time
  public static int numTreesRecursive(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    int sum = 0;
    for (int i=0; i<n; i++) {
      sum += numTreesRecursive(i) * numTreesRecursive(n-i-1);
    }
    return sum;
  }
}
