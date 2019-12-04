package jpa.spring.hibernate;

import jpa.spring.hibernate.config.JPAConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * created by Nikita_Ermakov at 12/4/2019
 */
public class Application {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new AnnotationConfigApplicationContext(JPAConfig.class);
        MyRunner runner = context.getBean(MyRunner.class);
        runner.go();
    }
}
