package africa.semicolon.ofofo.controllers;

import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import africa.semicolon.ofofo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/post")
    public String createPost(@RequestBody
                                 CreatePostRequest createPostRequest) {
        postService.createPost(createPostRequest);
        return "Post Created Successfully";
    }

    @GetMapping("post/{id}")
    public Post viewPost(@PathVariable String id) {
        return postService.viewPost(id);
    }

    @DeleteMapping("/post/{id}")
    String deletePostById(@PathVariable String id) {
        postService.deletePost("id");
        return "Post Has Been Deleted";
    }
}
