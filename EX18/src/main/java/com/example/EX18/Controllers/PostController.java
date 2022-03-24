package com.example.EX18.Controllers;

import com.example.EX18.Entity.Post;
import com.example.EX18.Entity.User;
import com.example.EX18.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String addPosts(String text, Model model, @AuthenticationPrincipal User user) {
        Post post = new Post();
        post.setText(text);
        post.setAuthor(user);
        post.setCreationDate(dateFormat.format(new Date()));
        System.out.println(post);
        service.savePost(post);
        List<Post> postList = service.getPosts();
        model.addAttribute("posts", postList);
        return "posts";
    }

    @PostMapping("/posts/{id}")
    public String deletePost(Model model, @PathVariable Long id) {
        service.deletePost(service.findPost(id));
        List<Post> postList = service.getPosts();
        model.addAttribute("posts", postList);
        return "redirect:/posts";
    }
}
