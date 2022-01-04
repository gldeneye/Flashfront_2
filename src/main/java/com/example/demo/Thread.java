package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Thread {
    private String title;
    private List<String> comments;

    public Thread(String title, ArrayList comments) {
        this.title = title;
        this.comments = comments;
    }

    public Thread() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(String comment) {
        this.comments.add(comment);
    }

    public boolean isNew() {
        return this.title == null;
    }
}
