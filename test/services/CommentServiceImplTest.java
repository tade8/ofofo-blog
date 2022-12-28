package services;

import africa.semicolon.ofofo.Main;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.services.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;

//    @BeforeEach
//    void setUp() {
//        commentService = new CommentServiceImpl();
//    }

    @Test
    void test_That_One_Can_Create_Comment() {
        CreateCommentRequest commentRequest = new CreateCommentRequest();
        commentRequest.setComment("My new Comment");
        commentService.createComment(commentRequest);
        assertEquals(1L, commentService.viewAllComments().size());
    }

    @Test
    void test_That_One_Can_View_Comment_By_Id() {
        CreateCommentRequest commentRequest = new CreateCommentRequest();

        commentRequest.setComment("My first comment");
        commentService.createComment(commentRequest);
        assertEquals(1L, commentService.viewAllComments().size());
        assertEquals("My first comment",
                commentService.viewComment("1").getComment());

        commentRequest.setComment("My second comment");
        commentService.createComment(commentRequest);
        assertEquals(2L, commentService.viewAllComments().size());
        assertEquals("My second comment",
                commentService.viewComment("2").getComment());

    }
}