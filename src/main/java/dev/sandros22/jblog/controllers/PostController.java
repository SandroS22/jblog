package dev.sandros22.jblog.controllers;

import dev.sandros22.jblog.entities.Post;
import dev.sandros22.jblog.services.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController()
@RequestMapping("/post")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts() {
        return postService.findAll();
    }

    @GetMapping("/{postId}")
    public Object getPost(@PathVariable UUID postId) {
        Post post = postService.findById(postId);
        return Objects.requireNonNullElseGet(post, () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found"));
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@Valid @RequestBody Post post) {
        post.setPostDate(new Date());
        postService.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping
    public ResponseEntity<Void> updatePost(@RequestBody Post post) {
        Post oldPost = postService.findById(post.getPostID());
        if (oldPost == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            oldPost.setContent(post.getContent());
            postService.update(oldPost);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID postId) {
        Post post = postService.findById(postId);
        if (post == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            postService.delete(postId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
