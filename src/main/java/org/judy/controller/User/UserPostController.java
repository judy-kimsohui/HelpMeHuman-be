package org.judy.controller.User;

import lombok.RequiredArgsConstructor;
import org.judy.dto.User.UserPostResponse;
import org.judy.service.User.UserPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/post")
@RequiredArgsConstructor
public class UserPostController {

    private final UserPostService userPostService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserPostResponse> getUserPosts(@PathVariable Long userId) {
        UserPostResponse response = userPostService.getUserPosts(userId);
        return ResponseEntity.ok(response);
    }

}
