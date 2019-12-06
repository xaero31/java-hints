package jpa.springboot.hibernate;

import jpa.springboot.hibernate.model.Post;
import jpa.springboot.hibernate.model.User;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Arrays;

/**
 * created by Nikita_Ermakov at 12/4/2019
 */
@SpringBootApplication
public class SpringBootJpaDemo implements CommandLineRunner, ApplicationContextAware {

    private static ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaDemo.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {
        EntityManager entityManager = context.getBean(EntityManager.class);

        Post post1 = new Post(0, "post 1", null);
        Post post2 = new Post(0, "post 2", null);
        Post post3 = new Post(0, "post 3", null);

        User user = new User(0, "Admin", "Adminov", Arrays.asList(post1, post2, post3));

        post1.setAuthor(user);
        post2.setAuthor(user);
        post3.setAuthor(user);

        entityManager.persist(user);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
