package org.ceva.ex1.proxies;

import org.ceva.ex1.model.Comment;

/**
 * Cuando la responsabilidad de un objeto es establecer comunicacion con algo fuera de la app
 * llamamos a esos objetos proxies.
 */
public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
