package com.ceva.repositories;

import com.ceva.model.Comment;
import org.springframework.stereotype.Component;

/*
 * @Component le dice a Spring que cree una instancia de esta clase y la agregue al Context
 */
@Component
public class DBCommentRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
