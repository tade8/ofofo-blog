package africa.semicolon.ofofo.data.repositories;

import africa.semicolon.ofofo.data.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    Optional<Post> findPostById(String id);

    @Override
    void deleteById(String id);

    Post findPostByTitle(String title);
}
