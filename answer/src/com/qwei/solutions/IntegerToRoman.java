package com.qwei.solutions;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * The hint for this problem: remember the following Roman integer expression
 */
public class IntegerToRoman {
  public static String intToRoman(int num) {
    String[] digits = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] thousands = {"", "M", "MM", "MMM"};

    String ret = "";
    String thousandDigit = thousands[num/1000];
    ret = ret + thousandDigit;
    num = num % 1000;

    String hundredDigit = hundreds[num/100];
    ret = ret + hundredDigit;
    num = num % 100;

    String tenDigit = tens[num/10];
    ret = ret + tenDigit;
    num = num % 10;

    ret = ret + digits[num];
    return ret;
  }
}
