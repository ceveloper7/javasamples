package org.ceva;


import org.ceva.config.ProjectConfig;
import org.ceva.model.Comment;
import org.ceva.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Beans Prototype en el mundo real
 */
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var commentService = context.getBean(CommentService.class);

        commentService.sendComment(new Comment());
        commentService.sendComment(new Comment());
    }
}