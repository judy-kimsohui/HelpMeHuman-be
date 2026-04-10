package org.judy.controller.Post;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.judy.dto.Post.PostRequest;
import org.judy.dto.Post.PostResponse;
import org.judy.service.Post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostRequest request) {
        try {
            PostResponse response = postService.createPost(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("createPost 실패");
        }
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable Long postId, @RequestBody PostRequest request) {
        PostResponse response = postService.updatePost(postId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        String response = "삭제 완료;";
        postService.deletePost(postId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getPostInfo(@PathVariable Long postId) {
        PostResponse response = postService.getPostInfo(postId);
        return ResponseEntity.ok(response);
    }
}
