package com.ceva.processors;

import com.ceva.model.Comment;
import com.ceva.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * Ya que queremos que CommentProcessor se beneficie de las capacidades de spring de inyeccion de dependencia, esta clase debe ser un Bean
 * CommentProcessor debe ser un bean de spring para beneficiarse del DI pero no puede ser un singleton bean porque si varios
 * subprocesos lo utilicen se produciera un condition race. Queremos que cada llamada de metodo obtenga una instancia diferente del objeto
 * CommentProcessor por ello lo declaramos como SCOPE_PROTOTYPE
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {
    @Autowired
    private CommentRepository commentRepository;
    private Comment comment;

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Comment getComment() {
        return this.comment;
    }

    public void processComment(Comment comment) {
    }

    public void validateComment(Comment comment) {
    }
}
