package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.data.repositories.PostRepository;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentService commentService;

    @Override
    public void createPost(CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setBody(createPostRequest.getBody());
        postRepository.save(post);
    }
    
    @Override
    public void updatePost(String id, String title, String body) {
        Post post = new Post();
        post.setTitle(post.getTitle());
        post.setBody(post.getBody());
    }

    @Override
    public void deletePost(String id) {
        Post post = postRepository.findPostById(id);
        postRepository.delete(post);
    }

    @Override
    public void deletePostByTitle(String title) {
        Post post = postRepository.findPostByTitle(title);
        postRepository.delete(post);
    }

    @Override
    public Post viewPost(String title) {
        return postRepository.findPostByTitle(title);
    }
    @Override
    public void addComment(CreateCommentRequest createCommentRequest) {
        Comment savedComment = commentService.createComment(createCommentRequest);
        Post savedPost = postRepository.findPostById(createCommentRequest.getId());
        savedPost.getComments().add(savedComment);
        postRepository.save(savedPost);
    }

    @Override
    public List<Post> viewAllPost() {
        return postRepository.findAll();
    }
}
