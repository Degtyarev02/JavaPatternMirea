package com.example.EX18.Repos;

import com.example.EX18.Entity.Post;
import com.example.EX18.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
