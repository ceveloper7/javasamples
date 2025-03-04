package com.ceva.services;

import com.ceva.model.Comment;
import com.ceva.proxies.CommentNotificationProxy;
import com.ceva.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*
 * @Component le dice a Spring que cree una instancia de esta clase y la agregue al Context
 */
@Service
public class CommentService {
    /*
     * Declaramos las dependencias de los componentes CommentRepository y CommentNotificationProxy
     * Spring al notar que los atributos estan definidos como Interface, lo que hace es buscar en su Context
     * beans creados con clases que implementan estas interfaces.
     */
    //@Autowired
    private final CommentRepository commentRepository;
    //@Autowired
    private final CommentNotificationProxy commentNotificationProxy;

    /*
     * Como solo hay un constructor en la clase la anotacion @Autowired es opcional.
     */
    //@Autowired
    public CommentService(CommentRepository commentRepository,
                          // especificamos la implementacion que queremos que sea injectada EmailCommentNotificationProxy
                          @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy){
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
