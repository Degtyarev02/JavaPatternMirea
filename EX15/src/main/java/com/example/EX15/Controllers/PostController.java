package com.example.EX15.Controllers;

import com.example.EX15.Entity.Post;
import com.example.EX15.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {


    @Autowired
    Service service;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM");

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/posts")
    public String addPosts(Model model) {
        List<Post> postList = service.getPosts();
        model.addAttribute("posts", postList);
        return "posts";
    }

    @PostMapping("/posts")
    public String addPosts(String text, Model model, String user) {
        Post post = new Post();
        post.setText(text);
        post.setAuthor(service.findUser(user));
        post.setCreationDate(dateFormat.format(new Date()));
        service.savePost(post);
        List<Post> postList = service.getPosts();
        model.addAttribute("posts", postList);
        return "posts";
    }

    @PostMapping("/posts/{id}")
    public String deletePost(Model model, @PathVariable String id) {
        service.deletePost(service.findPost(id));
        List<Post> postList = service.getPosts();
        model.addAttribute("posts", postList);
        return "redirect:/posts";
    }
}
