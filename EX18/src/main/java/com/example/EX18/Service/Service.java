package com.example.EX18.Service;

import com.example.EX18.Entity.Post;
import com.example.EX18.Entity.Role;
import com.example.EX18.Entity.User;
import com.example.EX18.Repos.PostRepo;
import com.example.EX18.Repos.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
@Transactional
public class Service {


    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepo;

    @Autowired
    MailSenderService serviceSender;

    @Autowired
    PostRepo postRepo;

    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<User> getUsers() {
        log.info("Find all users");
        return userRepo.findAll();
    }

    /**
     * Метод, который сохраняет пользователя
     *
     * @param user пользователь, которого необходимо сохранить
     */
    public void saveUser(User user) {
        if (user == null) {
            log.error("User to saved is null");
        } else {
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            log.info("User saved: " + user);
        }
    }

    /**
     * Метод, который удаляет пользователя
     *
     * @param user пользователь, которого необходимо удалить
     */
    public void deleteUser(User user) {
        //Удалим все посты пользователя
        postRepo.deleteAll(user.getPosts());
        user.getRoles().clear();
        userRepo.delete(user);
        log.info("User" + user + "delete");
    }

    public User findUser(Long id) {
        return session.createQuery("select u from User u where u.id=" + id, User.class).getSingleResult();
    }

    public List<User> userFilter(String field, String value) {
        CriteriaBuilder criteria = session.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = criteria.createQuery(User.class);
        Root<User> userRoot = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(userRoot).where(criteria.equal(userRoot.get(field), value));
        Query query = session.createQuery(userCriteriaQuery);
        return query.getResultList();
    }


    public List<Post> getPosts() {
        log.info("Find all posts");
        return postRepo.findAll();
    }

    @Transactional
    public void savePost(Post post) {
        if (post == null) {
            log.error("Post to save is null");
        } else {
            serviceSender.send("Пост создан " + post.getText());
            postRepo.save(post);
            log.info("Post " + post + " is create");
        }
    }

    public void deletePost(Post post) {
        if (post == null) {
            log.error("Post for delete is null");
        } else {
            post.setAuthor(null);
            postRepo.delete(post);
            serviceSender.send("Пост " + post.getText() + " удален");
            log.info("Post " + post + " is delete");
        }
    }

    public Post findPost(Long id) {
        return session.createQuery("select p from Post p where p.id=" + id, Post.class).getSingleResult();
    }
}
