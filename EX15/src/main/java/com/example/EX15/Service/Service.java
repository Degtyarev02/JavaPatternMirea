package com.example.EX15.Service;

import com.example.EX15.Entity.Post;
import com.example.EX15.Entity.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }
    public List<User> getUsers() {
        return session.createQuery("select u from User u", User.class).getResultList();
    }

    /**
     * Метод, который сохраняет пользователя
     * @param user пользователь, которого необходимо сохранить
     */
    public void saveUser(User user){
        var transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
    }

    /**
     * Метод, который удаляет пользователя
     * @param user пользователь, которого необходимо удалить
     */
    public void deleteUser(User user){
        //Удалим все посты пользователя
        for(Post post : user.getPosts()){
            deletePost(post);
        }
        var transaction = session.beginTransaction();
        //Удаляем пользователя
        session.delete(user);
        transaction.commit();
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
        return session.createQuery("select p from Post p", Post.class).getResultList();
    }

    public void savePost(Post post){
        var transaction = session.beginTransaction();
        session.saveOrUpdate(post);
        transaction.commit();
    }

    public void deletePost(Post post){
        var transaction = session.beginTransaction();
        post.setAuthor(null);
        session.delete(post);
        transaction.commit();
    }

    public Post findPost(String id){
        return session.createQuery("select p from Post p where p.id=" + id, Post.class).getSingleResult();
    }
}
