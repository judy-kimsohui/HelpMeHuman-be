package org.judy.controller.Author;

import lombok.RequiredArgsConstructor;
import org.judy.dto.Author.AuthorPostResponse;
import org.judy.entity.Post.Post;
import org.judy.service.Author.AuthorPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorPostController {

    private final AuthorPostService authorPostService;

    @Transactional(readOnly = true)
    @GetMapping("/{authorId}/posts")
    public ResponseEntity<List<Post>> getAuthorPosts(@PathVariable Long authorId) {
        List<Post> response = authorPostService.getAuthorPosts(authorId);
        return ResponseEntity.ok(response);
    }

}
