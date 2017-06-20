package com.qwei.observable.example;

/**
 * Created by qwei1 on 6/9/17.
 */
public class Test {

  public static void main(String[] args) {
    ExampleObservable example = new ExampleObservable();

    example.addObserver(new ExampleObserver());
    example.setData(1);
    example.setData(2);
    example.setData(3);
    example.setData(4);
    example.setData(5);
  }
}
