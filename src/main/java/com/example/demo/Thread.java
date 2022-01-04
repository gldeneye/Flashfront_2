package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Thread {
    private String title;
    private List<String> comments;

    public Thread(String title, ArrayList<String> comments) {
        this.title = title;
        this.comments = comments;
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

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public boolean isNew() {
        return isNew();
    }
}
