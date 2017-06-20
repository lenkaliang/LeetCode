package com.qwei.observable.example;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by qwei1 on 6/9/17.
 */
public class ExampleObserver implements Observer {

  @Override
  public void update(Observable object, Object argument) {
    ExampleObservable example = (ExampleObservable)object;
    System.out.println("example.data changed, the value of data is " + example.data);
  }
}
