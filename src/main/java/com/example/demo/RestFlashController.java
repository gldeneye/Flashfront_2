package com.example.demo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.events.Comment;
import java.util.List;

@RestController
public class RestFlashController {

    @Autowired
    public ThreadRepository threadRepository;

    @Autowired
    public UserRepository userRepository;

    // Threads
    @GetMapping("/restThreads")
    public List<Thread> listThread() {
        return threadRepository.getAllThreads();
    }

    @GetMapping("/restThreadByName/{name}")
    public Thread getThreadByName(@PathVariable String name) {
        return threadRepository.getThreadByName(name);
    }

    @GetMapping("/restThreadById/{id}")
    public Thread getThreadById(@PathVariable int id) {
        return threadRepository.getThreadById(id);
    }

    //Comments
    @GetMapping("/restComments/{id}")
    public List<Comments> listCommentsByThread(@PathVariable int id) {
        return threadRepository.listComments(id);
    }

    @GetMapping("/restAddComment/{threadId}/{forumUserId}/{comment}")
    public List<Comments> addComment(@PathVariable int threadId, @PathVariable int forumUserId, @PathVariable String comment) {
        Comments commentz = new Comments(null, threadId, forumUserId, comment);
        threadRepository.addComment(commentz);
        return threadRepository.listComments(threadId);
    }

    //ForumUsers
    @GetMapping ("/restUsers")
    public List <ForumUser> listUsers (){
        return userRepository.getUsers();
    }



}
