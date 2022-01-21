package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {
    private List<ForumUser> forumUsers;

    @Autowired
    private DataSource dataSource;

    public List <ForumUser> getUsers() {
        forumUsers = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * from FORUMUSER")) {

            while (rs.next()) {
                forumUsers.add(rsForumUser(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return forumUsers;
    }

    public ForumUser getUser(String username) {
        for (ForumUser forumUser : forumUsers) {
            if (forumUser.getUserName().equals(username)) {
                return forumUser;
            }
        }
        return null;
    }

    public List<ForumUser> getAllUsers() {
        return forumUsers;
    }

    public ForumUser addUser(ForumUser forumUser) {
        ForumUser lastForumUser = forumUsers.get(forumUsers.size() - 1);
        forumUsers.add(forumUser);
        return forumUser;
    }

    public ForumUser rsForumUser(ResultSet rs) throws SQLException {
        return new ForumUser(rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"));
    }

}
