package com.example.EX18.Controllers;

import com.example.EX18.Entity.Role;
import com.example.EX18.Entity.User;
import com.example.EX18.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class InitControllers extends WebMvcConfigurerAdapter {

    @Autowired
    UserRepo userRepo;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String showForm() {
        return "login";
    }

    @PostMapping("/login")
    public String validateLoginInfo(User user) {
        User ifExist = userRepo.findByUsername(user.getUsername());
        if (ifExist == null || !ifExist.getPassword().equals(user.getPassword())) {
            return "login";
        }
        return "redirect:/home";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {

        //Если пароль у пользователя существует и не равен паролю для подтверждения,
        //то добавляем в модель ошибку
        if (user.getPassword() != null && !user.getPassword().equals(user.getPassword2())) {
            model.addAttribute("passwordEqualsError", "Passwords are not equals");
            return "registration";
        }

        //Получаем пользователя из БД передавая имя нового пользователя
        User userFromDB = userRepo.findByUsername(user.getUsername());
        //Если в бд такой пользователь существует, то выдаем сообщение об ошибке
        if (userFromDB != null) {
            model.addAttribute("message", "User is already exist");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);

        return "redirect:/login";

    }
}
