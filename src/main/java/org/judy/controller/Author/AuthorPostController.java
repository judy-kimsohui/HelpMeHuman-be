package org.judy.controller.Author;

import lombok.RequiredArgsConstructor;
import org.judy.dto.Author.AuthorPostResponse;
import org.judy.service.Author.AuthorPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors/post")
@RequiredArgsConstructor
public class AuthorPostController {

    private final AuthorPostService authorPostService;

    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorPostResponse> getAuthorPosts(@PathVariable Long authorId) {
        AuthorPostResponse response = authorPostService.getAuthorPosts(authorId);
        return ResponseEntity.ok(response);
    }

}
