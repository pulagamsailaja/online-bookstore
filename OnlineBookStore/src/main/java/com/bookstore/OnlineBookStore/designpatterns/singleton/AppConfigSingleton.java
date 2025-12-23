package com.bookstore.OnlineBookStore.designpatterns.singleton;

public class AppConfigSingleton {

    private static AppConfigSingleton instance;

    private String mode = "PRODUCTION";

    private AppConfigSingleton() {
        System.out.println("AppConfigSingleton created once!");
    }

    public static synchronized AppConfigSingleton getInstance() {
        if (instance == null) {
            instance = new AppConfigSingleton();
        }
        return instance;
    }

    public String getMode() {
        return mode;
    }
}
