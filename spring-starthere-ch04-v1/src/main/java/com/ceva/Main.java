package com.ceva;

import com.ceva.config.ProjectConfiguration;
import com.ceva.model.Comment;
import com.ceva.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var comment = new Comment();
        comment.setAuthor("Pepito");
        comment.setText("La,la,la");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}