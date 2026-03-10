package org.ceva.ex1.services;

import org.ceva.ex1.model.Comment;
import org.ceva.ex1.proxies.CommentNotificationProxy;
import org.ceva.ex1.repositories.CommentRepository;

/**
 * Los objetos que implementan casos de uso se denominan Servicios.
 * CommentService depende de la abstraccion de: CommentNotificationProxy y CommentRepository
 */

public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy){
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    /**
     * Caso de Uso: Publish Comment
     * @param comment
     */
    public void publishComment(Comment comment){
        // usamos la responsabilidad del repository para almacenar el comentario
        commentRepository.storeComment(comment);

        // usamos la responsabilidad del proxy
        commentNotificationProxy.sendComment(comment);
    }
}
