package com.bookstore.OnlineBookStore.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderNotificationManager {
    private List<OrderObserver> observers = new ArrayList<>();

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String message) {
        for (OrderObserver observer : observers) {
            observer.update(message);
        }
    }
}
