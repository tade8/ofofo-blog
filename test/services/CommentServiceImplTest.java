package services;

import africa.semicolon.ofofo.Main;
import africa.semicolon.ofofo.data.repositories.CommentRepository;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.services.CommentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    private CreateCommentRequest commentRequest;

    @BeforeEach
    public void setUp() {
        commentRequest = new CreateCommentRequest();
    }
    @AfterEach
    public void tearDown() {
        commentRepository.deleteAll();
    }

    @Test
    void test_That_One_Can_Create_Comment() {
        commentRequest.setComment("My new Comment");
        commentService.createComment(commentRequest);
        assertEquals(1L, commentService.viewAllComments().size());
    }

    @Test
    void test_That_One_Can_View_Comment_By_Id() {
        commentRequest.setComment("My first comment");
        commentService.createComment(commentRequest);
        assertEquals(1L, commentService.viewAllComments().size());

        commentRequest.setComment("My second comment");
        commentService.createComment(commentRequest);
        assertEquals(2L, commentService.viewAllComments().size());
    }
}
