package com.qwei.solutions;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {
  public static String simplifyPath(String path) {
    String[] array = path.split("/");
    StringBuffer buf = new StringBuffer();

    for (int i=0; i<array.length; i++) {
      if (array[i].equals(".") || array[i].isEmpty()) {
        continue;
      } else if (array[i].equals("..")) {
        // back up 1 layer
        for (int j=buf.length()-1; j>=0; j--) {
          if (buf.charAt(j) == '/') {
            buf.deleteCharAt(j);
            break;
          }
          buf.deleteCharAt(j);
        }
      } else {
        // one layer further
        buf.append("/");
        buf.append(array[i]);
      }
    }

    if (buf.length() == 0) {
      return "/";
    }
    return buf.toString();
  }
}
