package org.judy.controller.Author;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.judy.dto.Author.*;
import org.judy.service.Author.AuthorRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorRegisterController {

    private final AuthorRegisterService authorRegisterService;

    @PostMapping
    public ResponseEntity<?> createAuthor(@Valid @RequestBody AuthorSignupRequest request) {
        try {
            AuthorSignupResponse response = authorRegisterService.createAuthor(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("createAuthor 실패");
        }
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorInfoResponse> getAuthorInfo(@PathVariable Long authorId) {
        AuthorInfoResponse response = authorRegisterService.getAuthorInfo(authorId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{authorId}")
    public ResponseEntity<AuthorUpdateResponse> updateAuthor(@PathVariable Long authorId, @Valid @RequestBody AuthorUpdateRequest request) {
        AuthorUpdateResponse response = authorRegisterService.updateAuthor(authorId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long authorId) {
        String response = "삭제 완료";
        authorRegisterService.deleteAuthor(authorId);
        return ResponseEntity.ok(response);

        // return ResponseEntity.noContent().build();
    }
}
