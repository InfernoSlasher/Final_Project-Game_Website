package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.service.finalservice;

@Controller
public class finalcontroller {

    @Autowired
    finalservice ser;
    //private String email;
    
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/game1")
    public String play() {
        return "sudoku";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String reg(@ModelAttribute User user, Model model) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("email", user.getEmail());
        ser.Add(user);
        if (user.getPassword().equals(user.getConfirmPassword())) {
            
            return "index";
       }
        
        return "redirect:/";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model) {
        User user = ser.getByEmail(email);
        //System.out.println(user);
        if (user != null && user.getPassword().equals(password)) {
            // Login successful, redirect to a success page or the home page
            model.addAttribute("message", "Login successful!");
            return "index";
        } else {
            // Login failed, display an error message on the login page
            model.addAttribute("errorMessage", "Invalid username or password");
            return "redirect:/";
}
}
    @GetMapping("/game2")
    public String game() {
        return "game2";
    }
}