package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Thread {
    private Integer id;
    private String name;
    private List<String> comments = new ArrayList<>();



    public Thread(Integer id, String name) {
        this.name = name;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
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
        return this.name == null;
    }

    public Object setComments() {
        return null;
    }

    public int getNumOfComments(){
        int numOfComments = comments.size();
        return numOfComments;
    }
}
