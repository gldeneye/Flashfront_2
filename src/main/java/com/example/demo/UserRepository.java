package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {
    private List<ForumUser> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new ForumUser("Adam","password"));
        users.add(new ForumUser("Alex","password"));
        users.add(new ForumUser("Carl","password"));
        users.add(new ForumUser("Erik","password"));
    }

    public ForumUser getUser(String username) {
        for (ForumUser user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public List<ForumUser> getAllUsers() {
        return users;
    }

    public ForumUser addUser(ForumUser user) {
        ForumUser lastUser = users.get(users.size() - 1);
        users.add(user);
        return user;
    }

}
