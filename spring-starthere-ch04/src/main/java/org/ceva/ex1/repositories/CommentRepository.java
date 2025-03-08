package org.ceva.ex1.repositories;

import org.ceva.ex1.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
