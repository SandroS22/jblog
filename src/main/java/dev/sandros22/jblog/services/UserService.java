package dev.sandros22.jblog.services;

import dev.sandros22.jblog.entities.user.User;
import dev.sandros22.jblog.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserDetails findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findById(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(UUID userId) {
        userRepository.deleteById(userId);
    }
}
