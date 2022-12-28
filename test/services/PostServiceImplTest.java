//package services;
//
//import africa.semicolon.ofofo.data.models.Comment;
//import africa.semicolon.ofofo.data.models.Post;
//import africa.semicolon.ofofo.data.repositories.PostRepository;
//import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
//import africa.semicolon.ofofo.services.PostService;
//import africa.semicolon.ofofo.services.PostServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import static org.junit.jupiter.api.Assertions.*;
//@Service
//class PostServiceImplTest {
//@Autowired
//private PostService postService;
//@Autowired
//private PostRepository postRepository;
//
//    @BeforeEach
//    void setUp() {
////        postService = new PostServiceImpl();
//
//    }
//
//    @Test
//    void create_And_Save_Post_Test() {
//        CreatePostRequest createPostRequest = new CreatePostRequest();
//        createPostRequest.setBody("Egusi is my best soup");
//        createPostRequest.setTitle("New Post");
//        postService.createPost(createPostRequest);
//
//        CreatePostRequest savedPost = postRepository.save(createPostRequest);
//        assertNotNull(savedPost);
//        assertEquals(1L, postService.viewAllPost().size());
//    }
//
//    @Test
//    void viewPostTest() {
//        CreatePostRequest createPostRequest = new CreatePostRequest();
//        createPostRequest.setTitle("New Title");
//        createPostRequest.setBody("New body");
//        postService.createPost(createPostRequest);
//
//        Post post = postService.viewPost(1);
//
//        assertEquals("New Title", post.getTitle());
//        assertEquals("New body", post.getBody());
//        assertNotNull(post.getCreationTime());
//    }
//
//    @Test
//    void one_Can_Add_Comment_To_Post_Test() {
//        CreatePostRequest createPostRequest = new CreatePostRequest();
//        createPostRequest.setTitle("New Title");
//        createPostRequest.setBody("New Body");
//        postService.createPost(createPostRequest);
//
//        Comment comment = new Comment();
//        comment.setComment("New Comment");
//        postService.addComment("1", comment);
//
//        Post savedPost = postService.viewPost("1");
//        assertEquals(1, savedPost.getComments().size());
//        assertEquals("New Comment", savedPost.getComments().get(0).getComment());
//    }
//}
