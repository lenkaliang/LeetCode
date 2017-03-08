package com.qwei.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address
 * combinations.
 *
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 */
public class RestoreIpAddress {
  public static List<String> restoreIpAddress(String s) {
    List<String> list = new ArrayList<>();

    // if s is invalid
    if (s == null || s.length() < 4 || s.length() > 12) {    // 注意这里的corner case
      return list;
    }

    helper(list, s, "", 0);
    return list;
  }


  public static void helper(List<String> list, String s, String temp, int step) {
    if (step == 3) {
      if (isValid(s)) {
        list.add(temp + s);
      }
      return;
    }

    for (int i=1; i<4 && i<s.length(); i++) {
      String sub = s.substring(0, i);
      if (isValid(sub)) {
        helper(list, s.substring(i), temp+sub+".", step+1);
      }
    }
  }

  public static boolean isValid(String s) {
    if (s.charAt(0) == '0') {
      return s.equals("0");
    }

    int number = Integer.parseInt(s);
    return 0<=number && number <= 255;
  }
}
