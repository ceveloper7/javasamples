package com.ceva.proxies;

import com.ceva.model.Comment;
import org.springframework.stereotype.Component;

/*
 * @Component le dice a Spring que cree una instancia de esta clase y la agregue al Context
 */
@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification for comment: " + comment.getText());
    }
}
