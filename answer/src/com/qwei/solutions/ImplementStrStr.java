package com.qwei.solutions;

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 */
public class ImplementStrStr {
  public static int strStr(String haystack, String needle) {
    if (haystack == null || needle == null || haystack.length() < needle.length()) {
      return -1;
    }

    if (needle.isEmpty()) {
      return 0;
    }

    int ret = -1;
    for (int i=0; i<=haystack.length() - needle.length(); i++) {
      String subString = haystack.substring(i, i+needle.length());
      if (subString.equals(needle)) {
        ret = i;
        break;
      }
    }

    return ret;
  }
}
