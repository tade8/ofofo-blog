package services;

import africa.semicolon.ofofo.Main;
import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.data.repositories.PostRepository;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import africa.semicolon.ofofo.services.PostService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = Main.class)
class  PostServiceImplTest {
    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    private final CreatePostRequest createPostRequest =
            new CreatePostRequest();
    private final CreateCommentRequest createCommentRequest =
            new CreateCommentRequest();

    @AfterEach
    void tearDown() {
        postRepository.deleteAll();
    }

    @Test
    void create_Post_Test() {
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");

        postService.createPost(createPostRequest);

        assertEquals(1L, postService.viewAllPost().size());
    }

    @Test
    void viewPostTest() {
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");
        postService.createPost(createPostRequest);

        Post post = postService.viewPost(createPostRequest.getTitle());

        assertEquals("New Post", post.getTitle());
        assertEquals("Egusi is my best soup", post.getBody());
        assertNotNull(post.getCreationTime());
    }

    @Test
    void one_Can_Add_Comment_To_Post_Test() {
        createPostRequest.setTitle("New Title");
        createPostRequest.setBody("New Body");
        postService.createPost(createPostRequest);

        Post savedPost = postService.viewPost(
                createPostRequest.getTitle());

        createCommentRequest.setComment("New Comment");
        createCommentRequest.setId(savedPost.getId());
        postService.addComment(createCommentRequest);

        savedPost = postService.viewPost(createPostRequest.getTitle());

        assertEquals(1, savedPost.getComments().size());
        assertEquals("New Comment", savedPost.
                getComments().get(0).getComment());
    }

    @Test
    public void cantViewDeletedPost() throws RuntimeException {
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");

        postService.createPost(createPostRequest);
        assertNotNull(createPostRequest);
        postService.deletePostByTitle("New Post");

        assertEquals(0L, postService.viewAllPost().size());
    }
}
