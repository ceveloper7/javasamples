package com.ceva.proxies;

import com.ceva.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
