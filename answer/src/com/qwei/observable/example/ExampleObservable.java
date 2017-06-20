package com.qwei.observable.example;

import java.util.Observable;

/**
 * Created by qwei1 on 6/9/17.
 */
public class ExampleObservable extends Observable {
  int data = 0;

  public void setData(int data) {
    this.data = data;
    this.setChanged();
    this.notifyObservers();
  }
}
