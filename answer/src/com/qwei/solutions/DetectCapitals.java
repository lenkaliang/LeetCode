package com.qwei.solutions;

/**
 * https://leetcode.com/problems/detect-capital/#/description
 */
public class DetectCapitals {
  public boolean detectCapitalUse(String word) {
    boolean shouldBeLowerCase = false;
    if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
      shouldBeLowerCase = true;
    }

    boolean isValid = true;
    if (shouldBeLowerCase) {
      for (int i = 1; i < word.length(); i++) {
        if (isUpperCase(word.charAt(i))) {
          isValid = false;
          break;
        }
      }
    } else {
      boolean shouldBeAllUpperCase = false;
      if (word.length() >= 2) {
        if (isUpperCase(word.charAt(1))) {
          shouldBeAllUpperCase = true;
        }

        for (int i = 2; i < word.length(); i++) {
          if (shouldBeAllUpperCase) {
            if (!isUpperCase(word.charAt(i))) {
              isValid = false;
            }
          } else {
            if (isUpperCase(word.charAt(i))) {
              isValid = false;
            }
          }
        }
      }
    }
    return isValid;
  }

  public boolean isUpperCase(char c) {
    return c >= 'A' && c <= 'Z';
  }
}
