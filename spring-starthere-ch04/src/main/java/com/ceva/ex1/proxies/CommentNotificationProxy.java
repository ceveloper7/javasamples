package com.ceva.ex1.proxies;

import com.ceva.ex1.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
