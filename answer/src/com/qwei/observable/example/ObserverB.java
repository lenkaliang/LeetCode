package com.qwei.observable.example;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by qwei1 on 6/9/17.
 */
public class ObserverB extends Observable implements Observer {

  int data = 0;

  @Override
  public void update(Observable object, Object obj) {
    System.out.println("ObserverB found ObserverA change just now...");
  }

  public void setData(int i) {
    this.data = i;

    this.setChanged();
    this.notifyObservers();
  }
}
