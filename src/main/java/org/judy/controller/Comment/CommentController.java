package org.judy.controller.Comment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.judy.dto.Comment.CommentRequest;
import org.judy.dto.Comment.CommentResponse;
import org.judy.service.Comment.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<?> createComment(@Valid @RequestBody CommentRequest request) {
        try {
            CommentResponse response = commentService.createComment(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("createComment 실패");
        }
    }

    @PatchMapping("/{commentId}")
    public ResponseEntity<CommentResponse> updateComment(@PathVariable Long commentId, @Valid @RequestBody CommentRequest request) {
        CommentResponse response = commentService.updateComment(commentId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        String response = "삭제 완료";
        commentService.deleteComment(commentId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentResponse> getCommentInfo(@PathVariable Long commentId) {
        CommentResponse response = commentService.getCommentInfo(commentId);
        return ResponseEntity.ok(response);
    }
}
