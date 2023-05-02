package services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.data.repositories.CommentRepository;
import africa.semicolon.ofofo.data.repositories.PostRepository;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import africa.semicolon.ofofo.services.PostServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class  PostServiceImplTest {
    @InjectMocks
    private PostServiceImpl postService;
    @Mock
    private PostRepository postRepository;
    @Mock
    private CommentRepository commentRepository;
    private CreatePostRequest createPostRequest;
    private CreateCommentRequest createCommentRequest;

    @BeforeEach
    void setUp() {
        createPostRequest = new CreatePostRequest();
        createCommentRequest = new CreateCommentRequest();
    }

    @Test
    void create_Post_Gets_Saved() {
        createPostRequest.setBody("Egusi is my best soup");
        createPostRequest.setTitle("New Post");

        when(postRepository.save(any())).then(returnsFirstArg());
        postService.createPost(createPostRequest);

        assertNotNull(createPostRequest);
        assertEquals("New Post", createPostRequest.getTitle());
    }

    @Test
    void viewPostTest() {
        Post post1 = new Post();
        post1.setTitle("Egusi");
        post1.setBody("Blank");

        when(postRepository.findPostById(createPostRequest.getId())).
                thenReturn(Optional.of(post1));
        Post post = postService.viewPost(createPostRequest.
                getTitle()).orElseThrow(()-> new RuntimeException("This post does not exist"));

        verify(postRepository).findPostById(createPostRequest.getId());
        assertNotNull(post.getCreationTime());
    }

    @Test
    void one_Can_Add_Comment_To_Post_Test() {
        Post post1 = new Post();
        post1.setTitle("New Title");
        post1.setBody("New Body");

        when(commentRepository.save(any())).then(returnsFirstArg());

        Comment comment = new Comment();
        comment.setComment("My comment");
        comment.setCommenterName("Emma");

        when(postRepository.findPostById(createPostRequest.getId())).
                thenReturn(Optional.of(post1));
        Post savedPost = postService.viewPost(createPostRequest.getId()).
                orElseThrow(()-> new RuntimeException("This post does not exist"));

        postService.addComment(createCommentRequest);

        assertEquals(1, savedPost.getComments().size());
        assertNotNull(savedPost);
    }

    @Test
    public void cantViewDeletedPost() {
        postService.deletePost("1");
        assertEquals(0, postService.viewAllPost().size());
    }

}
