package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Thread {
    private Integer id;
    private String name;
//    private List<String> comments = new ArrayList<>();


    public Thread(Integer id, String name) {
        this.name = name;
        this.id=id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<String> getComments() {
//        return comments;
//    }
//
//    public String getSpecificComment(int place) {
//        return comments.get(place);
//    }
//
//    public Object setComments(String comment) {
//        this.comments.add(comment);
//        return null;
//    }

    public boolean isNew() {
        return this.name == null;
    }


//    public int getNumOfComments(){
//        int numOfComments = comments.size();
//        return numOfComments;
//    }
}
