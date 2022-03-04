package com.example.EX14.Controllers;

import com.example.EX14.Entity.Post;
import com.example.EX14.Entity.User;
import com.example.EX14.Repos.PostRepo;
import com.example.EX14.Repos.UserRepo;
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
    PostRepo postRepo;

    @Autowired
    UserRepo userRepo;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM");

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/posts")
    public String addPosts(Model model) {
        List<Post> postList = postRepo.findAll();
        model.addAttribute("posts", postList);
        return "posts";
    }

    @PostMapping("/posts")
    public String addPosts(String text, Model model, User user) {
        Post post = new Post();
        post.setText(text);
        post.setAuthor(user);
        post.setCreationDate(dateFormat.format(new Date()));
        postRepo.save(post);
        List<Post> postList = postRepo.findAll();
        model.addAttribute("posts", postList);
        return "posts";
    }

    @PostMapping("/posts/{id}")
    public String deletePost(Model model, @PathVariable Post id) {
        id.setAuthor(null);
        postRepo.delete(id);
        List<Post> postList = postRepo.findAll();
        model.addAttribute("posts", postList);
        return "redirect:/posts";
    }
}
