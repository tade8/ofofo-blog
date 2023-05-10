package africa.semicolon.ofofo.controllers;

import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.services.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public String addComment(@RequestBody CreateCommentRequest commentRequest) {
        commentService.createComment(commentRequest);
        return "Comment added";
    }
}
