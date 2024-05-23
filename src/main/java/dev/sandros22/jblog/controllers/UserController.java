package dev.sandros22.jblog.controllers;

import dev.sandros22.jblog.entities.Post;
import dev.sandros22.jblog.entities.User;
import dev.sandros22.jblog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public Object getUser(@PathVariable UUID userId) {
        User user = userService.findById(userId);
        return Objects.requireNonNullElseGet(user, () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@Valid @RequestBody User user) {
        user.setCreated(new Date());
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping
    public ResponseEntity<Void> updatePost(@RequestBody User user) {
        User oldUser = userService.findById(user.getUserId());
        if (oldUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            BeanUtils.copyProperties(user, oldUser);
            userService.save(oldUser);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID userId) {
        User user = userService.findById(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            userService.delete(userId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
