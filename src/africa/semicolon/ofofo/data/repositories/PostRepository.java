package africa.semicolon.ofofo.data.repositories;

import africa.semicolon.ofofo.data.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    Post findPostById(String id);
}