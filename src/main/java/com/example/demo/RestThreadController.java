package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestThreadController {

    @Autowired
    public ThreadRepository threadRepository;

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

}
