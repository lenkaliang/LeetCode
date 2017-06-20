package com.qwei.observable.example;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by qwei1 on 6/9/17.
 */
public class ObserverA extends Observable implements Observer {

  @Override
  public void update(Observable object, Object obj) {
    ObserverB observerB = (ObserverB)object;
    System.out.println("ObserverB change, the new value of observerB.data is " + observerB.data);
    this.setChanged();
    this.notifyObservers();
  }
}
