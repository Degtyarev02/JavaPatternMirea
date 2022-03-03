package com.example.EX14.Controllers;

import com.example.EX14.Entity.Post;
import com.example.EX14.Repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostRepo repo;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM");

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        List<Post> postList = repo.findAll();
        model.addAttribute("posts", postList);
        return "posts";
    }

    @PostMapping("/posts")
    public String posts(String text, Model model) {
        Post post = new Post();
        post.setText(text);
        post.setCreationDate(dateFormat.format(new Date()));
        repo.save(post);
        List<Post> postList = repo.findAll();
        model.addAttribute("posts", postList);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}")
    public String posts(Model model, @PathVariable Long id) {
        repo.deleteById(id);
        List<Post> postList = repo.findAll();
        model.addAttribute("posts", postList);
        return "redirect:/posts";
    }
}
