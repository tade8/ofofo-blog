package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {
    void createPost(CreatePostRequest createPostRequest);
    void updatePost(String id, String title, String body);
    void deletePost(String id);
    void deletePostByTitle(String title);
    Optional<Post> viewPost(String id);
    void addComment(CreateCommentRequest createCommentRequest);
    List<Post> viewAllPost();
}
