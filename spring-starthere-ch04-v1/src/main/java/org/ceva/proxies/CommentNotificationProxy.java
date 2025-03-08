package org.ceva.proxies;

import org.ceva.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
