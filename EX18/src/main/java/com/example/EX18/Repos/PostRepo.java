package com.example.EX18.Repos;

import com.example.EX18.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
