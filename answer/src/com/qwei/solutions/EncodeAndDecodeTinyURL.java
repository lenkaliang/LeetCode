package com.qwei.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Problem: description: https://leetcode.com/problems/encode-and-decode-tinyurl/#/description
 *
 * Note the following thing: the url should be converted to exactly as base + hash (hash is 6 chars
 * String generated from base 62)
 */
public class EncodeAndDecodeTinyURL {
  private Map<String, String> longToHash = new HashMap<>();
  private Map<String, String> hashToLong = new HashMap<>();
  private String base = "http://tinyurl.com/";
  private String base62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  Random r = new Random();

  public String encode(String longUrl) {
    if (longToHash.containsKey(longUrl)) {
      return longToHash.get(longUrl);
    }

    String hash = "";
    for (int i = 0; i < 6; i++) {
      hash += longUrl.charAt(r.nextInt(base62.length()));
    }
    String url = base + hash;

    longToHash.put(longUrl, url);
    hashToLong.put(url, longUrl);

    return url;
  }

  public String decode(String shortUrl) {
    return hashToLong.get(shortUrl);
  }
}
