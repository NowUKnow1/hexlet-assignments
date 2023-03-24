package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@RequestMapping("/posts")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    // BEGIN
    @GetMapping(path = "/{postId}/comments")
    public Iterable<Comment> getCommentsByPostId(@PathVariable long postId) {
        return commentRepository.findAllByPostId(postId);
    }
    @GetMapping(path = "/{postId}/comments/{commentId}")
    public Comment getCommentById(@PathVariable long postId, @PathVariable long commentId) {
        return commentRepository.findByIdAndPostId(commentId, postId)
                .orElseThrow(() -> new ResourceNotFoundException("Comments for post " + postId + "not found"));
    }
    @PostMapping(path = "/{postId}/comments")
    public Comment createComment(@PathVariable long postId, @RequestBody Comment comment) {
        comment.setPost(postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post" + postId + "not found")));
        return commentRepository.save(comment);
    }
    @PatchMapping(path = "/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable long postId, @PathVariable long commentId, @RequestBody Comment comment) {

        if (!commentRepository.existsById(commentId)) {
            throw new ResourceNotFoundException("Comment not found");
        }
        comment.setPost(postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post" + postId + "not found")));
        comment.setId(commentId);
        return commentRepository.save(comment);
    }
    @DeleteMapping(path = "/{postId}/comments/{commentId}")
    public void deleteComment(@PathVariable long postId, @PathVariable long commentId) {
        Comment comment = commentRepository.findByIdAndPostId(postId, commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));
        commentRepository.delete(comment);
    }
    // END
}