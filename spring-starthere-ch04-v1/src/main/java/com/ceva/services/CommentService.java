package com.ceva.services;

import com.ceva.model.Comment;
import com.ceva.proxies.CommentNotificationProxy;
import com.ceva.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * @Component le dice a Spring que cree una instancia de esta clase y la agregue al Context
 */
@Component
public class CommentService {
    /*
     * Declaramos las dependencias de los componentes CommentRepository y CommentNotificationProxy
     * Spring al notar que los atributos estan definidos como Interface, lo que hace es buscar en su Context
     * beans creados con clases que implementan estas interfaces.
     */
    @Autowired
    private final CommentRepository commentRepository;
    @Autowired
    private final CommentNotificationProxy commentNotificationProxy;

    /*
     * Como solo hay un constructor en la clase la anotacion @Autowired es opcional.
     */
    //@Autowired
    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy){
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
