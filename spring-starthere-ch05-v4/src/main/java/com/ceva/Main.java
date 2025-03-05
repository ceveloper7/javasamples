package com.ceva;

import com.ceva.config.ProjectConfig;
import com.ceva.services.CommentService;
import com.ceva.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Declarando Beans con ambito Prototype mediante anotaciones Stereotype
 */
public class Main {
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var s1 = c.getBean(CommentService.class);
        var s2 = c.getBean(UserService.class);

        boolean b = s1.getCommentRepository() == s2.getCommentRepository(); // false

        System.out.println(b);
    }
}