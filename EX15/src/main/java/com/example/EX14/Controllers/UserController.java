package com.example.EX14.Controllers;

import com.example.EX14.Entity.User;
import com.example.EX14.Repos.UserRepo;
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
    UserRepo repo;

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = repo.findAll();
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
        repo.save(user);
        List<User> users = repo.findAll();
        model.addAttribute("users", users);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}")
    public String deleteUsers(Model model, @PathVariable Long id) {
        repo.deleteById(id);
        List<User> users = repo.findAll();
        model.addAttribute("users", users);
        return "redirect:/users";
    }
}
