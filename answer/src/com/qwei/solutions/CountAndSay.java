package com.qwei.solutions;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows: 1, 11, 21, 1211,
 * 111221, ... 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read off as
 * "one 2, then one 1" or 1211. Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
  public static String countAndSay(int n) {
    if (n <= 0) {
      return "";
    }
    if (n == 1) {
      return "1";
    }

    String sequence = "1";

    for (int i = 2; i <= n; i++) {
      StringBuffer buf = new StringBuffer();
      int count = 0;
      char pre = sequence.charAt(0);
      for (int j = 0; j < sequence.length(); j++) {
        char c = sequence.charAt(j);
        if (c == pre) {
          count++;
        } else {
          buf.append(count).append(pre);
          pre = c;
          count = 1;
        }
      }
      sequence = buf.append(count).append(pre).toString();        // bug: take care of the last round
    }

    return sequence;
  }
}
