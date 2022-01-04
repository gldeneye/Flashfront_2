package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ForumController {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private ThreadRepository threadRepository;

    @GetMapping("/")
    public String threads(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {

        List<Thread> threads = getPage(page-1, PAGE_SIZE);
        int pageCount = numberOfPages(PAGE_SIZE);
        int[] pages = toArray(pageCount);

        model.addAttribute("thread", threads);
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", page);
        model.addAttribute("showPrev", page > 1);
        model.addAttribute("showNext", page < pageCount);

        return "startpage";
    }

    @GetMapping("/business")
    public String business(){
        return "business";
    }

    @PostMapping("/business")
    public String businessPost(HttpSession session, @RequestParam String item){
        List<String> list = (List<String>)session.getAttribute("businessList");
        if (list == null) {
            list = new ArrayList<>();
            session.setAttribute("businessList", list);
        }
        list.add(item);

        return "business";
    }

    @GetMapping("/politics")
    public String politics(){
        return "politics";
    }

    @PostMapping("/politics")
    public String politicsPost(HttpSession session, @RequestParam String politicItem){
        List<String> politicList = (List<String>)session.getAttribute("politicList");
        if (politicList == null) {
            politicList = new ArrayList<>();
            session.setAttribute("politicList", politicList);
        }
        politicList.add(politicItem);

        return "politics";
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

}
