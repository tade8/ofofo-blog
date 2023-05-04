package africa.semicolon.ofofo.controllers;

import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import africa.semicolon.ofofo.services.PostService;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public String createPost(@RequestBody CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
        return "Post Created Successfully";
    }

    @GetMapping("post/{id}")
    public Optional<Post> viewPost(@PathVariable String id) {
        return postService.viewPost(id);
    }

    @DeleteMapping("/post/{id}")
    String deletePostById(@PathVariable String id) {
        postService.deletePost(id);
        return "Post Has Been Deleted";
    }

    @PostMapping("/post/{id}/")
    String addCommentToPost(@RequestBody CreateCommentRequest createCommentRequest) {
        postService.addComment(createCommentRequest);
        return "New comment added";
    }
}
