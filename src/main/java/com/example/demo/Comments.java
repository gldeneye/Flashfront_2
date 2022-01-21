package com.example.demo;

public class Comments {
    private Integer Id;
    private Integer threadId;
    private Integer forumUserId;
    private String comment;

    public Comments(Integer id, Integer threadId, Integer forumUserId, String comment) {
        Id = id;
        this.threadId = threadId;
        this.forumUserId = forumUserId;
        this.comment = comment;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getThreadId() {
        return threadId;
    }

    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    public Integer getForumUserId() {
        return forumUserId;
    }

    public void setForumUserId(Integer forumUserId) {
        this.forumUserId = forumUserId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
