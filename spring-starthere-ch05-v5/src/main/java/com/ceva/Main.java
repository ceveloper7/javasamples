package com.ceva;


import com.ceva.config.ProjectConfig;
import com.ceva.model.Comment;
import com.ceva.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.spel.ast.Projection;

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