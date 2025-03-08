package org.ceva;

import org.ceva.config.ProjectConfiguration;
import org.ceva.model.Comment;
import org.ceva.services.CommentService;
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