package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ThreadController {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private ThreadRepository threadRepository;


    @GetMapping("/")
    public String threads(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {

        List<Thread> threads = getPage(page - 1, PAGE_SIZE);
        int pageCount = numberOfPages(PAGE_SIZE);
        int[] pages = toArray(pageCount);

        model.addAttribute("threads", threads);
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("showPrev", page > 1);
        model.addAttribute("showNext", page < pageCount);
        return "threads";
    }

    @GetMapping("/thread/{page}/{id}")
    public String thread(Model model, @PathVariable Integer page, @PathVariable int id) {
        Thread thread = threadRepository.getThreadById(id);
        List<Comments> comments = threadRepository.listComments(id);
        model.addAttribute("page", page);
        model.addAttribute("thread", thread);
        model.addAttribute("comments", comments);

        return "thread";
    }

    private int[] toArray(int num) {
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    private List<Thread> getPage(int page, int pageSize) {
        List<Thread> threads = threadRepository.getAllThreads();
        int from = Math.max(0, page * pageSize);
        int to = Math.min(threads.size(), (page + 1) * pageSize);

        return threads.subList(from, to);
    }

    private int numberOfPages(int pageSize) {
        List<Thread> books = threadRepository.getThreads();
        return (int) Math.ceil(new Double(books.size()) / pageSize);
    }

    @GetMapping("/addThread")
    public String addThread(Model model) {
        model.addAttribute("thread",new Thread(10,"placeholder"));
        return "formThread";
    }

    @PostMapping("/savethread")
    public String saveThread(Model model, @ModelAttribute Thread thread, @RequestParam String name) {
        threadRepository.addThread(thread);
        return "redirect:/";
    }

    @PostMapping("/saveComment")
    public String setComment(HttpSession session, Model model, @RequestParam String comment, @RequestParam String name) {
        Thread thread = threadRepository.getThreadByName(name);
        Integer forumUserId = (Integer) session.getAttribute("forumUserId");
        threadRepository.addComment(new Comments(null, thread.getId(), forumUserId, comment));
        model.addAttribute("thread",thread);
            return "redirect:/thread/1/" + thread.getId();
        }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable String title) {
        Thread thread = threadRepository.getThread(title);
        model.addAttribute(thread);
        return "form";
    }

}
