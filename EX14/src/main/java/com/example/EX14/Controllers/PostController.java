package com.example.EX14.Controllers;

import com.example.EX14.Entity.Post;
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

    private final List<Post> postList = new ArrayList<>();
    private static int ID = 0;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM");

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postList);
        return "posts";
    }

    @PostMapping("/posts")
    public String posts(String text, Model model) {
        Post post = new Post();
        post.setId(ID++);
        post.setText(text);
        post.setCreationDate(dateFormat.format(new Date()));
        postList.add(post);
        model.addAttribute("posts", postList);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}")
    public String posts(Model model, @PathVariable int id) {

        for (Post post : postList) {
            if (post.getId() == id) {
                postList.remove(post);
                model.addAttribute("posts", postList);
                return "redirect:/posts";
            }
        }
        model.addAttribute("posts", postList);
        return "posts";
    }
}
