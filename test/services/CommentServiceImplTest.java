package services;

import africa.semicolon.ofofo.data.repositories.CommentRepository;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.services.CommentServiceImpl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;
    private CreateCommentRequest commentRequest;
    @InjectMocks
    private CommentServiceImpl commentService;

    @BeforeEach
    void setUp() {
        commentRequest = new CreateCommentRequest();
    }

    @Test
    void test_That_One_Can_Create_Comment() {
        commentRequest.setComment("My new Comment");

        when(commentRepository.save(any())).then(returnsFirstArg());
        var comment = commentService.createComment(commentRequest);

        assertNotNull(comment);
        assertEquals(commentRequest.getComment(), "My new Comment");
    }

}
