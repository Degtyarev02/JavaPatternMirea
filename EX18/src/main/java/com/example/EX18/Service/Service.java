package com.example.EX18.Service;

import com.example.EX18.Entity.Post;
import com.example.EX18.Entity.User;
import com.example.EX18.Repos.PostRepo;
import com.example.EX18.Repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Service {


    @Autowired
    UserRepo userRepo;

    @Autowired
    PostRepo postRepo;

    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    /**
     * Метод, который сохраняет пользователя
     * @param user пользователь, которого необходимо сохранить
     */
    public void saveUser(User user){
        userRepo.save(user);
    }

    /**
     * Метод, который удаляет пользователя
     * @param user пользователь, которого необходимо удалить
     */
    public void deleteUser(User user){
        //Удалим все посты пользователя
        postRepo.deleteAll(user.getPosts());
        userRepo.delete(user);
    }

    public User findUser(String id){
        return session.createQuery("select u from User u where u.id=" + id, User.class).getSingleResult();
    }

    public List<User> userFilter(String field, String value){
        CriteriaBuilder criteria = session.getCriteriaBuilder();
        CriteriaQuery<User> userCriteriaQuery = criteria.createQuery(User.class);
        Root<User> userRoot = userCriteriaQuery.from(User.class);
        userCriteriaQuery.select(userRoot).where(criteria.equal(userRoot.get(field), value));
        Query query = session.createQuery(userCriteriaQuery);
        return query.getResultList();
    }




    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    public void savePost(Post post){
       postRepo.save(post);
    }

    public void deletePost(Post post){
        post.setAuthor(null);
        postRepo.delete(post);
    }

    public Post findPost(String id){
        return session.createQuery("select p from Post p where p.id=" + id, Post.class).getSingleResult();
    }
}
