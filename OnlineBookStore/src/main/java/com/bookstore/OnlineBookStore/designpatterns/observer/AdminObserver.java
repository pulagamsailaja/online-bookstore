package com.bookstore.OnlineBookStore.designpatterns.observer;

public class AdminObserver implements OrderObserver {
    private String adminEmail;

    public AdminObserver(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @Override
    public void update(String message) {
        System.out.println("📩 Admin (" + adminEmail + ") Notification: " + message);
    }
}
