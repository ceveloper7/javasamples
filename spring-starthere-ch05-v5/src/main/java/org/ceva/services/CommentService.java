package org.ceva.services;

import org.ceva.model.Comment;
import org.ceva.processors.CommentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CommentService {


    /*
     * Inyectamos el ApplicationContext para obtener una instancia del bean CommentProcessor alojado en el Spring context
     * No debemos inyectar el bean CommentProcessor dentro del bean CommentService, ya que este ultimo bean es SIngleton
     * lo que significa que Spring crea una sola instancia de CommentService como consecuencia  Spring inyectara las dependencias
     * de CommentService una sola vez por lo que terminaremos con una sola instancia de CommentProcessor.
     * Cada llamada a sendComment() usara la instancia unica por lo que multiples subprocessos se encontraran con los mismos
     * problemas de race condition que con un bean singleton.
     */
    @Autowired
    private ApplicationContext context;

    // para cada llamada a este metodo, necesitamos una instancia de CommentProcessor
    public void sendComment(Comment comment){
        CommentProcessor p = context.getBean(CommentProcessor.class);

        p.setComment(comment);
        p.processComment(comment);
        p.validateComment(comment);

        comment = p.getComment();
    }
}
