package com.qwei.javabasics;

/**
 * This class shows the example of creating Thread by extending Thread class
 */
public class ThreadExample extends Thread {
  private String threadName;

  public ThreadExample(String threadName) {
    this.threadName = threadName;
  }

  @Override
  public void run() {
    try {
      for (int i=0; i<4; i++) {
        System.out.println(this.threadName + " " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException ex) {
      System.out.println(this.threadName + " got interrupted");
    }
    System.out.println(this.threadName + " is exiting");
  }

  public static void main(String[] args) {
    Thread t1 = new ThreadExample("Thread one");
    Thread t2 = new ThreadExample("Thread two");

    t1.start();
    t2.start();
  }
}
