package com.example.EX15.Controllers;

import com.example.EX15.Entity.User;
import com.example.EX15.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/users")
    public String addUser(Model model,
                          String firstName,
                          String middleName,
                          String lastName,
                          String birthDate
    ) {
        User user = new User();
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setBirthDate(birthDate);
        service.saveUser(user);
        List<User> users = service.getUsers();
        model.addAttribute("users", users);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}")
    public String deleteUsers(Model model, @PathVariable String id) {
        User user = service.findUser(id);
        service.deleteUser(user);
        List<User> users = service.getUsers();
        model.addAttribute("users", users);
        return "redirect:/users";
    }
}
