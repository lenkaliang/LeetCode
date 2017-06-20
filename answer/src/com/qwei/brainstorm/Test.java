package com.qwei.brainstorm;

import com.qwei.solutions.DivideTwoIntegers;
import com.qwei.utils.TreeNode;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qwei1 on 3/16/17.
 */

public class Test {

  public int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }

  public int[][] multiply(int[][] A, int[][] B) {
    int[][] ret = new int[A.length][B[0].length];

    int i=0;
    while (i<A.length) {
      int[] temp1 = A[i];

      // add up product of each element in temp1 and each column of B. Note that B has A[0].length rows
      for (int j=0; j<B[0].length; j++) {
        int[] temp2 = new int[B.length];
        for (int line=0; line<B.length; line++) {
          temp2[line] = B[line][j];
        }

        int sum = 0;
        for (int index=0; index<temp1.length; index++) {
          sum += temp1[index] * temp2[index];
        }
        ret[i][j] =  sum;
      }
      i++;
    }

    System.out.println("[");
    for (int s=0; s<ret.length; s++) {
      for (int t = 0; t<ret[0].length; t++) {
        System.out.print(ret[s][t]);
        System.out.print(", ");
      }
      System.out.println();
    }
    System.out.print("]");
    return ret;
  }

  public int maxProduct(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int[][] dp = new int[nums.length][2];

    dp[0][0] = 1;
    dp[0][1] = nums[0];

    for (int i=1; i<nums.length; i++) {
      dp[i][0] = Math.max(dp[0][0], dp[0][1]);
      dp[i][1] = Math.max(nums[i], dp[0][1]*nums[i]);
    }

    System.out.println("[");
    for (int s=0; s<dp.length; s++) {
      for (int t = 0; t<dp[0].length; t++) {
        System.out.print(dp[s][t] + ", ");
      }
      System.out.println();
    }
    System.out.println("]");

    return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
  }

  public void reverseWords(char[] s) {
    reverse(s, 0, s.length-1);

    int i=0;
    int start = i, end = i;
    while (i<s.length) {
      if (s[i] == ' ') {
        end = i-1;

        reverse(s, start, end);
        start = i+1;
        i = start;
        continue;
      }
      i++;
    }

    if (start >= end) {
      reverse(s, start, i-1);
    }
  }

  public void reverse(char[] s, int start, int end) {
    while (start < end) {
      char c = s[start];
      s[start] = s[end];
      s[end] = c;
      start++;
      end--;
    }
  }

  private boolean checkAccountNumberEligibility(BigInteger accountNumber) {
    if (accountNumber == BigInteger.ZERO) {
      return false;
    }

    char checksum = 0;
    BigInteger offset = BigInteger.valueOf((long) 0xFF);

    for (int i = 1; i < 8; i++) {
      checksum += accountNumber.shiftRight(i * 8).and(offset).intValue();
    }

    return (accountNumber.and(offset).intValue() == checksum % 256);
  }

  public static void main(String[] args) {
    List<Integer> l = new ArrayList<Integer>();

    for (int i=0; i<10; i++) {
      l.add(i);
    }

    l.stream()
        .filter(i -> (i%3 == 0))
        .forEach(System.out::println);
  }
}
