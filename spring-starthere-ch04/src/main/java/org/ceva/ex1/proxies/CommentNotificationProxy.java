package org.ceva.ex1.proxies;

import org.ceva.ex1.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
