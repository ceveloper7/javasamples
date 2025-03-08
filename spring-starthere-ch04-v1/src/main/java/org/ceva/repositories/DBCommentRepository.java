package org.ceva.repositories;

import org.ceva.model.Comment;
import org.springframework.stereotype.Repository;

/*
 * @Component le dice a Spring que cree una instancia de esta clase y la agregue al Context
 */
@Repository
public class DBCommentRepository implements CommentRepository{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
