package org.example;

import org.example.Entity.Fighter;
import org.example.Entity.Judoka;
import org.example.configuration.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Fighter fighter = context.getBean(args[0],Fighter.class);
        Fighter fighter1 = context.getBean(args[1],Fighter.class);
        Fighter fighter2 = context.getBean(args[2],Fighter.class);
        fighter.doFight();
        fighter1.doFight();
        fighter2.doFight();
    }
}
