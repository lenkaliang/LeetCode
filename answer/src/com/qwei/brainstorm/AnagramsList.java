package com.qwei.brainstorm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * From Twilio interview.
 *
 * Design an algorithm to get all valid anagrams English words of given word
 *
 * Thought about permutations first. This is going to cause really bad complexity. Use HashMap as
 * data structure to pre process the dictionary which will be used as look up tool for teach valid
 * English word.
 *
 * Remember to pre process the dictinary when you actually create the object of this class.
 */
public class AnagramsList {
  Set<String> dict;
  Map<String, Set<String>> map;

  public AnagramsList(Set<String> dict) {
    this.dict = dict;
    this.preProcessDictionary(); // If the getAnagrams api will called huge number of times, it is a
                                 // benifit to pre process the map when you create the object of
                                 // AnagramsList. Make sure to jump out of the box.
  }

  public void preProcessDictionary() {
    for (String string : dict) {
      String sorted = this.sort(string);

      if (map.containsKey(sorted)) {
        map.get(sorted).add(string);
      } else {
        Set<String> set = new HashSet<>();
        set.add(string);
        map.put(sorted, set);
      }
    }
  }

  public String sort(String word) {
    char[] array = word.toCharArray();
    Arrays.sort(array);

    return new String(array);
  }

  public Set<String> getAnagrams(String word) {
    if (word == null || word.isEmpty()) {
      return new HashSet<String>();
    }

    String sorted = this.sort(word);
    if (map.containsKey(sorted)) {
      return map.get(sorted);
    }

    return new HashSet<String>();
  }
}
