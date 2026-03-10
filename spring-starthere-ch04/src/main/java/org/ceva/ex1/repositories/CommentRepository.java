package org.ceva.ex1.repositories;

import org.ceva.ex1.model.Comment;

/**
 * Objeto que almacena comentarios en la base de datos
 */
public interface CommentRepository {
    void storeComment(Comment comment);
}
