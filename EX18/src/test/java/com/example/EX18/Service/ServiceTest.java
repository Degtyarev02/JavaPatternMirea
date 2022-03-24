package com.example.EX18.Service;

import com.example.EX18.Entity.Post;
import com.example.EX18.Entity.Role;
import com.example.EX18.Entity.User;
import com.example.EX18.Repos.PostRepo;
import com.example.EX18.Repos.UserRepo;
import org.checkerframework.checker.units.qual.A;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ServiceTest {

    @Autowired
    Service service;

    @MockBean
    private UserRepo userRepo;

    @MockBean
    private PostRepo postRepo;

    @MockBean
    private PasswordEncoder passwordEncoder;


    @Test
    void getUsers() {
        User user = new User();
        user.setUsername("Vasya");
        User user2 = new User();
        user2.setUsername("Dima");
        Mockito.when(userRepo.findAll()).thenReturn(List.of(user, user2));

        List<User> expected = service.getUsers();

        Mockito.verify(userRepo).findAll();
        Assertions.assertEquals(expected.size(), 2);
        Assertions.assertEquals(expected.get(0).getUsername(), "Vasya");
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setUsername("Test");
        user.setPassword("Test");
        service.saveUser(user);
        assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));
        assertTrue(user.isActive());
        Mockito.verify(userRepo, Mockito.times(1)).save(user);
    }


    @Test
    void getPosts() {
        Post post = new Post();
        post.setText("Some test text");
        Mockito.when(postRepo.findAll()).thenReturn(List.of(post));

        List<Post> expected = service.getPosts();

        Mockito.verify(postRepo).findAll();
        Assertions.assertEquals(expected.size(), 1);
        Assertions.assertEquals(expected.get(0).getText(), "Some test text");
    }

}