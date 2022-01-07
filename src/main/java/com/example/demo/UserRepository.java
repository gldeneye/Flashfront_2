package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {
    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("Adam","password"));
        users.add(new User("Alex","password"));
        users.add(new User("Carl","password"));
        users.add(new User("Erik","password"));
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User addUser(User user) {
        User lastUser = users.get(users.size() - 1);
        users.add(user);
        return user;
    }

}
