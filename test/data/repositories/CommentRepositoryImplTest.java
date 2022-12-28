//package data.repositories;
//
//import africa.semicolon.ofofo.data.models.Comment;
//import africa.semicolon.ofofo.data.repositories.CommentRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@Service
//class CommentRepositoryImplTest {
//    @Autowired
//    private CommentRepository commentRepository;
//
//    @BeforeEach
//    void setUp() {
////        commentRepository;
//    }
//
//    @Test
//    void test_That_Comments_Are_Saved_When_A_Comment_Is_Created() {
//        Comment comment = new Comment();
//        comment.setComment("My new comment");
//        commentRepository.save(comment);
//        assertEquals(1L, commentRepository.count());
//    }
//
//    @Test
//    void test_That_When_One_Saves_In_The_Repository_It_Saves_By_Id() {
//        Comment comment = new Comment();
//        comment.setComment("My new comment");
//        commentRepository.save(comment);
//        assertEquals(1L, commentRepository.count());
//        assertEquals(comment, commentRepository.findById("1"));
//    }
//
//    @Test
//    void test_That_When_One_Deletes_Comment_It_Gets_Deleted() {
//        Comment comment = new Comment();
//        comment.setComment("My new comment");
//        commentRepository.save(comment);
//        assertEquals(1L, commentRepository.count());
//        assertEquals(comment, commentRepository.findById("1"));
//
//        commentRepository.deleteById("1");
//        assertEquals(0L, commentRepository.count());
//    }
//}
