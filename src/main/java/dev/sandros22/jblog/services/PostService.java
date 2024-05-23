package dev.sandros22.jblog.services;


import dev.sandros22.jblog.entities.Post;
import dev.sandros22.jblog.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(UUID id) {
        return postRepository.findById(id).orElse(null);
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void delete(UUID postId) {
        postRepository.deleteById(postId);
    }

    public void update(Post post) {
        postRepository.save(post);
    }
}
