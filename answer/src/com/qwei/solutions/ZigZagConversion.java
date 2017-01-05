package com.qwei.solutions;

import java.util.Arrays;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * for(letter i: string), depends on numRows given, the program will fill first column. From the last row, going back
 * from the last row to the first row, each row it reaches, it will assign a letter to that row.
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows == 1) {
            return s;
        }

        String[] ans = new String[numRows];   // construct an array of String, each String element holds one row
        Arrays.fill(ans, "");

        int row = 0;                          // indicate which row it currently reaches
        int marker = 1;                       // used to move to next row or previous row

        for (int i = 0; i < s.length(); i++) {
            ans[row] += s.charAt(i);          // append current letter to the current row
            row = row + marker;               // move to next row if marker == 1, move to previouse row if marker == -1

            if (row == numRows) {             // already reached the last row after adding marker
                row = numRows - 2;            // move to second last row
                marker = -1;                  // start moving up
            }

            if (row < 0) {                   // already reached the first row after adding marker (-1)
                row = 1;                      // move to the second row
                marker = 1;                   // start moving down
            }
        }

        String ret = "";
        for (String string: ans) {
            ret = ret + string;
        }

        return ret;
    }
}
