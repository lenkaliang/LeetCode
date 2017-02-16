package com.qwei.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class ValidSudoku {
  public static boolean isValid(char[][] board) {
    if (board == null || board.length == 0) {
      return false;
    }

    Set<Character> set = new HashSet<>();

    // validate lines
    for (int col = 0; col < board[0].length; col++) {
      for (int row = 0; row < board.length; row++) {
        if (isNumber(board[row][col])) {
          if (!set.add(board[row][col])) {
            return false;
          }
        } else {
          if (board[row][col] != '.') {
            return false;
          }
        }
      }
      set.clear();
    }

    set.clear();

    //validate columns
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (isNumber(board[row][col])) {
          if (!set.add(board[row][col])) {
            return false;
          }
        } else {
          if (board[row][col] != '.') {
            return false;
          }
        }
      }
      set.clear();
    }

    set.clear();

    // validate each 3x3 cells
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 3 * i; k < 3 * (i + 1); k++) {
          for (int l = 3 * j; l < 3 * (j + 1); l++) {
            if (isNumber(board[k][l])) {
              if (!set.add(board[k][l])) {
                return false;
              }
            } else {
              if (board[k][l] != '.') {
                return false;
              }
            }
          }
        }
        set.clear();
      }
    }

    return true;
  }

  public static boolean isNumber(char c) {
    return c >= '0' && c <= '9';
  }
}
