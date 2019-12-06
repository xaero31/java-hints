package jpa.spring.hibernate;

import jpa.springboot.hibernate.model.Post;
import jpa.springboot.hibernate.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * created by Nikita_Ermakov at 12/4/2019
 */
@Component
public class SimpleJpaOperationsTestRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void run() {
        Post post1 = new Post(0, "post 1", null);
        Post post2 = new Post(0, "post 2", null);
        Post post3 = new Post(0, "post 3", null);

        User user = new User(0, "Admin", "Adminov", Arrays.asList(post1, post2, post3));

        post1.setAuthor(user);
        post2.setAuthor(user);
        post3.setAuthor(user);

        entityManager.persist(user);

        List<User> list = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        System.out.println(list);
    }
}
