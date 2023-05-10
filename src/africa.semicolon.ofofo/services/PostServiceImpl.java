package africa.semicolon.ofofo.services;

import africa.semicolon.ofofo.data.models.Comment;
import africa.semicolon.ofofo.data.models.Post;
import africa.semicolon.ofofo.data.repositories.CommentRepository;
import africa.semicolon.ofofo.data.repositories.PostRepository;
import africa.semicolon.ofofo.dtos.requests.CreateCommentRequest;
import africa.semicolon.ofofo.dtos.requests.CreatePostRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

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
        postRepository.deleteById(id);
    }

    @Override
    public void deletePostByTitle(String title) {
        Post post = postRepository.findPostByTitle(title);
        postRepository.delete(post);
    }

    @Override
    public Optional<Post> viewPost(String id) {
        return postRepository.findPostById(id);
    }

    @Override
    public void addComment(CreateCommentRequest createCommentRequest) {
        Comment comment = new Comment();

        comment.setComment(createCommentRequest.getComment());
        comment.setCommenterName(createCommentRequest.getCommenterName());
        var savedComment = commentRepository.save(comment);

        Post savedPost = postRepository.findPostById(createCommentRequest.getId()).
                orElseThrow(()-> new RuntimeException("This post does not exist"));
        savedPost.getComments().add(savedComment);

        postRepository.save(savedPost);
    }

    @Override
    public List<Post> viewAllPost() {
        return postRepository.findAll();
    }
}
