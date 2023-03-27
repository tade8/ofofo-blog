package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.data.repositories.CommentRepository;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl  implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(CreateCommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        comment.setCommenterName(commentRequest.getCommenterName());
        return commentRepository.save(comment);
//        postService.addComment(commentRequest.getId(), savedComment);
    }

    public Comment viewComment(String comment) {
        return commentRepository.findCommentByComment(comment);
    }

    public List<Comment> viewAllComments() {
        return commentRepository.findAll();
    }
}
