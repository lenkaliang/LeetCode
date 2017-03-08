package com.qwei.solutions;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring.
 *
 * The same letter cell may not be used more than once.
 *
 * https://leetcode.com/problems/word-search/?tab=Description
 *
 *
 */
public class WordSearch {
  private static int row;
  private static int col;

  public static boolean exists(char[][] board, String word) {
    if (board == null || board.length == 0) {
      return false;
    }

    row = board.length;
    col = board[0].length;
    boolean[][] visited = new boolean[row][col];

    // each cell can be the start point
    for (int i=0; i<row; i++) {
      for (int j=0; j<col; j++) {
        if(helper(board, visited, word, i, j, 0)) { 
          return true;
        }
      }
    }
    return false;
  }

  public static boolean helper(char[][] board, boolean[][] visited, String word, int rowIndex, int colIndex, int index) {
    if (index == word.length()) {
      return true;
    }

    // if going out of range, return false
    if (rowIndex < 0 || colIndex < 0 || rowIndex >= row || colIndex >= col) {
      return false;
    }

    // if the char is not the one you are looking for, return false
    if (board[rowIndex][colIndex] != word.charAt(index)) {
      return false;
    }

    // if the current cell has been visited, return false
    if (visited[rowIndex][colIndex]) {
      return false;
    }

    visited[rowIndex][colIndex] = true;
    boolean res = helper(board, visited, word, rowIndex+1, colIndex, index+1) ||
        helper(board, visited, word, rowIndex-1, colIndex, index+1) ||
        helper(board, visited, word, rowIndex, colIndex+1, index+1) ||
        helper(board, visited, word, rowIndex, colIndex-1, index+1);
    visited[rowIndex][colIndex] = false;         // Finish current round set this cell to false
    return res;
  }
}
