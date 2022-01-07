package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/signIn")
    public String users(Model model) {
        return "signIn";
    }

    @PostMapping("/existingUser")
    public String loginExistingUser(HttpSession session,Model model, @RequestParam String username, @RequestParam String password) {
        for (User user : userRepository.getAllUsers()) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                session.setAttribute("username", username);
                return "redirect:/";
            }
        }
        return "signIn";
    }

    @GetMapping("/newUser")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/saveUser")
    public String set(Model model, @ModelAttribute User user) {
        boolean occupiedUsername;
        for (User usser : userRepository.getAllUsers()) {
            if (!(usser.getUserName().equals(user.getUserName()))) {
                userRepository.addUser(user);
                for (User userz : userRepository.getAllUsers()) {
                    System.out.println(userz.getUserName());
                }
                return "redirect:/";
            }
        }
        occupiedUsername = true;
        model.addAttribute("occupiedUsername", occupiedUsername);
        return "userForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse res){
        Cookie cookie = new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0);
        res.addCookie(cookie);
        return "redirect:/";
    }

}
