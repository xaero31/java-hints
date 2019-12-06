package jpa.hibernate.spring;

import jpa.hibernate.spring.config.JPAConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * created by Nikita_Ermakov at 12/4/2019
 */
public class SpringJpaDemo {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
        SimpleJpaOperationsTestRunner runner = context.getBean(SimpleJpaOperationsTestRunner.class);
        runner.run();
    }
}
