package org.judy.controller.User;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.judy.dto.User.*;
import org.judy.entity.User.User;
import org.judy.service.User.UserRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRegisterController {

    private final UserRegisterService userRegisterService;

    @PostMapping
    public ResponseEntity<UserSignupResponse> createUser(@Valid @RequestBody UserSignupRequest request) {
        UserSignupResponse response = userRegisterService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoResponse> getUserInfo(@PathVariable Long userId) {
        UserInfoResponse response = userRegisterService.getUserInfo(userId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserUpdateResponse> updateUser(@PathVariable Long userId, @Valid @RequestBody UserUpdateRequest request) {
        UserUpdateResponse response = userRegisterService.updateUser(userId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        String response = "삭제 완료";
        userRegisterService.deleteUser(userId);
        return ResponseEntity.ok(response);

        // return ResponseEntity.noContent().build();
    }
}
