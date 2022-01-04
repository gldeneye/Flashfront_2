package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ForumController {

    @GetMapping("/")
    public String forum () {

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

}
