package com.bookstore.OnlineBookStore.designpatterns.factory;

import com.bookstore.OnlineBookStore.model.User;

/**
 * Factory Design Pattern for creating users based on type
 */
public class UserFactory {

    public static User createUser(UserType type) {
        User user = new User();

        switch (type) {
            case ADMIN:
                user.setRole("ADMIN");
                break;
            case CUSTOMER:
                user.setRole("CUSTOMER");
                break;
            case STUDENT:
                user.setRole("STUDENT");
                break;
            default:
                throw new IllegalArgumentException("Unknown user type: " + type);
        }

        return user;
    }
}
