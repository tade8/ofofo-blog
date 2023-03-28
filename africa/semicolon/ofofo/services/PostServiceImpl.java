package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.data.repositories.PostRepository;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    public void createPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setBody(createPostRequest.getBody());
        postRepository.save(post);
    }

    public void updatePost(String id, String title, String body) {
        Post post = new Post();
        post.setTitle(post.getTitle());
        post.setBody(post.getBody());
    }

    public void deletePost(String id) {
        Post post = postRepository.findPostById(id);
        postRepository.delete(post);
    }

    public Post viewPost(String id) {
        return postRepository.findPostById(id);
    }


    public void addComment(String id, Comment comment) {
        Post savedPost = postRepository.findPostById(id);
        savedPost.getComments().add(comment);
        postRepository.save(savedPost);
    }

    public List<Post> viewAllPost() {
        return postRepository.findAll();
    }
}
