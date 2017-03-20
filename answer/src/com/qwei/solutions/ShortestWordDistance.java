package com.qwei.solutions;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these
 * two words in the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding",
 * return 1.
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the
 * list.
 */
public class ShortestWordDistance {
  public int shortestDistance(String[] words, String word1, String word2) {
    int shortest = Integer.MAX_VALUE;

    int index1 = -1, index2 = -1;
    for (int i=0; i<words.length; i++) {
      if (words[i].equals(word1)) {
        index1 = i;
      }

      if (words[i].equals(word2)) {
        index2 = i;
      }

      if (index1 != -1 && index2 != -2) {
        shortest = Math.min(shortest, Math.abs(index1 - index2));
      }
    }
    return shortest;
  }
}
