package africa.semicolon.ofofo.data.repositories;

import africa.semicolon.ofofo.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    Comment findCommentById(String id);

    Comment findCommentByComment(String comment);
}
