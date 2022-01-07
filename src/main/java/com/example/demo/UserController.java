package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = new ArrayList<>();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/addUser")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/saveUser")
    public String set(@ModelAttribute User user) {
        return "redirect:/users";
    }
}
