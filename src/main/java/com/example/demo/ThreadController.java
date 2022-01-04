package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThreadController {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private ThreadRepository threadRepository;

    @GetMapping("/")
    public String threads(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {

        List<Thread> threads = getPage(page-1, PAGE_SIZE);
        int pageCount = numberOfPages(PAGE_SIZE);
        int[] pages = toArray(pageCount);

        model.addAttribute("threads", threads);
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("showPrev", page > 1);
        model.addAttribute("showNext", page < pageCount);

        return "threads";
    }

    @GetMapping("/thread/{page}/{title}")
    public String thread(Model model, @PathVariable Integer page, @PathVariable String title) {
        Thread thread = threadRepository.getThread(title); // todo replace with call GET /book/{id}
        model.addAttribute("page", page);
        model.addAttribute("thread", thread);
        model.addAttribute("comments", thread.getComments());
        return "thread";
    }

    private int[] toArray(int num) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i+1;
        }
        return result;
    }

    private List<Thread> getPage(int page, int pageSize) {
        List<Thread> threads = threadRepository.getThreads(); // todo replace with call GET /book
        int from = Math.max(0,page*pageSize);
        int to = Math.min(threads.size(),(page+1)*pageSize);

        return threads.subList(from, to);
    }

    private int numberOfPages(int pageSize) {
        List<Thread> books = threadRepository.getThreads(); // todo replace with call GET /book
        return (int)Math.ceil(new Double(books.size()) / pageSize);
    }

    @GetMapping("/addThread")
    public String addThread(Model model) {
        model.addAttribute("thread", new Thread());
        return "formThread";
    }

    @GetMapping("/addComment")
    public String addComment(Model model, @RequestParam String title, @RequestParam ArrayList<String> comments) {
        model.addAttribute("thread", new Thread(title, comments));
        return "form";
    }

    @PostMapping("/save")
    public String set(@ModelAttribute Thread thread) {
        if (thread.isNew()) {
            threadRepository.addThread(thread); // todo replace with call POST /book (with book object as json in request body)
        }
        else {
            threadRepository.editThread(thread);
            // todo replace with call PUT /book/{id} (with book object as json in request body
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable String title) {
        Thread thread = threadRepository.getThread(title); // todo replace with call GET /book/{id}
        model.addAttribute(thread);
        return "form";
    }

}
