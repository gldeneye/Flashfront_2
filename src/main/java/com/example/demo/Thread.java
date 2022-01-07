package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Thread {
    private String title;
    private List<String> comments = new ArrayList<>();

    public Thread(String title) {
        this.title = title;
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

    public String getSpecificComment(int place) {
        return comments.get(place);
    }

    public Object setComments(String comment) {
        this.comments.add(comment);
        return null;
    }

    public boolean isNew() {
        return this.title == null;
    }

    public Object setComments() {
        return null;
    }

    public int getNumOfComments(){
        int numOfComments = comments.size();
        return numOfComments;
    }
}
