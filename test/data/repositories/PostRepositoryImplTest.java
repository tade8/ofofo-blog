package data.repositories;

import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.data.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PostRepositoryImplTest {

    private PostRepository postRepository;

    @BeforeEach
    void setUp() {
//       postRepository = new RepositoryImpl();
    }

    @Test
    void test_SaveNewPost_Count_Should_Be_One() {
        Post post = new Post();

        post.setBody("Our post body");
        post.setTitle("Our Post Title");
        postRepository.save(post);

        assertEquals(1L, postRepository.count());
    }

    @Test
    void saveNewPost_FindById_ShouldReturnSavedPost() {
        Post post = new Post();
        post.setBody("Our post body");
        post.setTitle("Our Post Title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        Optional<Post> savedPost = postRepository.findById("1");
        assertEquals(post, savedPost);

        Post post2 = new Post();
        postRepository.save(post2);
        assertEquals(post2, postRepository.findById("2"));
    }

    @Test
    void savePost_UpdatePost_Count_IsOne() {
        Post post = new Post();
        post.setTitle("Our Title");
        post.setBody("Our post body");
        postRepository.save(post);

        Post updatedPost = new Post();
        updatedPost.setId("1");
        updatedPost.setTitle("Updated title");
        updatedPost.setBody("Updated body");
        postRepository.save(updatedPost);

        assertEquals(1L, postRepository.count());
        assertEquals(post, postRepository.findById("1"));
        assertEquals("Updated body", post.getBody());
    }
}