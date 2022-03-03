package com.example.EX14.Controllers;

import com.example.EX14.Entity.Post;
import com.example.EX14.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final List<User> users = new ArrayList<>();
    private static int ID = 0;

    @GetMapping("/users")
    public String users(Model model) {
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
        user.setId(ID++);
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setBirthDate(birthDate);
        users.add(user);
        model.addAttribute("users", users);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}")
    public String deleteUsers(Model model, @PathVariable int id) {

        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                model.addAttribute("users", users);
                return "users";
            }
        }
        model.addAttribute("users", users);
        return "users";
    }
}
