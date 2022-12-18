package africa.semicolon.ofofo.data.repositories;

import africa.semicolon.ofofo.data.models.Post;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    Post findPostById(String id);
}