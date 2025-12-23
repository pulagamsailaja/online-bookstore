package com.bookstore.OnlineBookStore;

import com.bookstore.OnlineBookStore.designpatterns.singleton.AppConfigSingleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineBookStoreApplication {

    public static void main(String[] args) {
        // Singleton pattern usage
        AppConfigSingleton config = AppConfigSingleton.getInstance();
        System.out.println("App Mode: " + config.getMode());

        SpringApplication.run(OnlineBookStoreApplication.class, args);
    }
}
