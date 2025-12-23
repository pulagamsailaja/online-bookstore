package com.bookstore.OnlineBookStore.designpatterns.observer;

public class UserObserver implements OrderObserver {
    private String userEmail;

    public UserObserver(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public void update(String message) {
        System.out.println("📩 User (" + userEmail + ") Notification: " + message);
    }
}
