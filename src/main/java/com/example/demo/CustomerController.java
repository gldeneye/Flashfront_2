package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @GetMapping("/customers")
    public String customers(Model model) {
        List<Customer> customers = new ArrayList<>(); // todo get all customers
        model.addAttribute("customers", customers);

        return "customers";
    }

    @GetMapping("/addCustomer")
    public String add(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    @PostMapping("/saveCustomer")
    public String set(@ModelAttribute Customer customer) {
        // todo save or update customer
        return "redirect:/customers";
    }
}
