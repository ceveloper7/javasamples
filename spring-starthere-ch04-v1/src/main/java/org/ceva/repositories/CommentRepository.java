package org.ceva.repositories;

import org.ceva.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
