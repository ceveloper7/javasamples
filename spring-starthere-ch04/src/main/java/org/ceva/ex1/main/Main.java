package org.ceva.ex1.main;

import org.ceva.ex1.model.Comment;
import org.ceva.ex1.proxies.EmailCommentNotificationProxy;
import org.ceva.ex1.repositories.DBCommentRepository;
import org.ceva.ex1.services.CommentService;

public class Main {
    public static void main(String[] args) {
        var commentRepository = new DBCommentRepository();
        var commentNotificationProxy = new EmailCommentNotificationProxy();

        var commentService = new CommentService(commentRepository, commentNotificationProxy);

        var comment = new Comment();
        comment.setAuthor("Ronny");
        comment.setText("Demo content");

        commentService.publishComment(comment);

    }

}
