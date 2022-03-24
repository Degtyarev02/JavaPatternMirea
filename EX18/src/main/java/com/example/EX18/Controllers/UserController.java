package com.example.EX18.Controllers;

import com.example.EX18.Entity.User;
import com.example.EX18.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    Service service;

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = service.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/users/{id}")
    public String deleteUsers(Model model, @PathVariable Long id) {
        User user = service.findUser(id);
        service.deleteUser(user);
        List<User> users = service.getUsers();
        model.addAttribute("users", users);
        return "redirect:/users";
    }

    @GetMapping("/users/filter")
    public String userFilter(Model model,
                             @RequestParam(defaultValue = "") String field,
                             @RequestParam(defaultValue = "") String value) {
        List<User> users = (field.equals("") || value.equals("")) ? service.getUsers() :
                service.userFilter(field, value);
        model.addAttribute("users", users);
        return "filter";
    }
}
