package com.ceva.repositories;

import com.ceva.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
