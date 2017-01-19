package com.qwei.javabasics;

/**
 * An example of how to create a java thread by implementing Runnable interface
 */
public class RunnableExample implements Runnable {

  private String threadName;

  public RunnableExample(String threadName) {
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
      System.out.println("This Thread got interrupted");
    }
    System.out.println(this.threadName + " is exiting");
  }

  public static void main(String[] args) {
    RunnableExample r1 = new RunnableExample("Thread one");
    Thread t1 = new Thread(r1);

    RunnableExample r2 = new RunnableExample("Thread two");
    Thread t2 = new Thread(r2);

    t1.start();
    t2.start();
  }
}
