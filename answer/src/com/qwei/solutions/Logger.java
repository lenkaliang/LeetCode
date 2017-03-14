package com.qwei.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a logger system that receive stream of messages along with its timestamps, each message
 * should be printed if and only if it is not printed in the last 10 seconds.
 *
 * Given a message and a timestamp (in seconds granularity), return true if the message should be
 * printed in the given timestamp, otherwise returns false.
 *
 * It is possible that several messages arrive roughly at the same time.
 *
 * Example:
 *
 * Logger logger = new Logger();

 * logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true;

 * logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;

 * logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;

 *logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;

 * logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;

 * logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 *
 * Note one thing you didn't think about: if a message should not be printed, you shouldn't update the map!
 * If you update the map when timestamp==10 in above example, you will return false when the timestamp is 11.
 */
public class Logger {
  private Map<String, Integer> map;
  public Logger() {
    map = new HashMap<>();
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    boolean shouldPrint = false;
    if (!map.containsKey(message) || timestamp-map.get(message) >= 10) {
      // when successfully prints the message, udpate the map
      map.put(message, timestamp);
      shouldPrint = true;
    }
    return shouldPrint;
  }
}
