package org.judy.service.Author;

import org.judy.entity.Author.Author;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.judy.dto.Author.AuthorPostResponse;
import org.judy.entity.Post.Post;
import org.judy.repository.Author.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorPostServiceImpl implements AuthorPostService {

    private final AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAuthorPosts(Long authorId) {

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 사용자 없음"));
        return author.getPosts();
    }
}