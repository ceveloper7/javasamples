package org.ceva;

import org.ceva.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.ceva.services.CommentService;
import org.ceva.services.UserService;

public class Main {
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var s1 = c.getBean(CommentService.class);
        var s2 = c.getBean(UserService.class);

        boolean b = s1.getCommentRepository() == s2.getCommentRepository(); // comparamos las referencias

        System.out.println(b);// true ambos servicios tienen la misma referencia CommentRepository ya que es singleton
    }
}