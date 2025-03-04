package com.ceva;

import com.ceva.config.ProjectConfiguration;
import com.ceva.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        // get singleton beans
        var cs1 = context.getBean("commentService", CommentService.class);
        var cs2 = context.getBean("commentService", CommentService.class);

        boolean b1 = cs1==cs2; // true, they have the same reference
        System.out.println(b1);
    }
}