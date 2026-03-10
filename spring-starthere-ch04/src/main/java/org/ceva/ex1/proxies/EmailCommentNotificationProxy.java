package org.ceva.ex1.proxies;

import org.ceva.ex1.model.Comment;

/**
 * Se envia el comentario a un especifico email address
 */
public class EmailCommentNotificationProxy implements CommentNotificationProxy{
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment: " + comment.getText());
    }
}
