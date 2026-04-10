package org.judy.service.Author;

import lombok.RequiredArgsConstructor;
import org.judy.dto.Author.*;
import org.judy.entity.Author.Author;
import org.judy.repository.Author.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthorRegisterServiceImpl implements AuthorRegisterService {

    private final AuthorRepository authorRepository;

    @Transactional
    @Override
    public AuthorSignupResponse createAuthor(AuthorSignupRequest request) {
        Author newAuthor = authorRepository.save(new Author(
                null,
                request.getAuthorName(),
                new ArrayList<>()
        ));
        return new AuthorSignupResponse(newAuthor.getAuthorName());
    }

    @Transactional
    @Override
    public AuthorUpdateResponse updateAuthor(Long authorId, AuthorUpdateRequest request) {
        Author updateAuthor = findAuthorById(authorId);
        updateAuthor.update(request.getAuthorName());
        return new AuthorUpdateResponse(updateAuthor.getAuthorName());
    }

    @Transactional
    @Override
    public void deleteAuthor(Long authorId) {
        Author deleteAuthor = findAuthorById(authorId);
        authorRepository.delete(deleteAuthor);
    }

    @Transactional(readOnly = true)
    @Override
    public AuthorInfoResponse getAuthorInfo(Long authorId) {
        Author authorInfo = findAuthorById(authorId);

        return new AuthorInfoResponse(authorInfo.getAuthorName());
    }

    private Author findAuthorById(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 사용자 없음"));    // AuthorNotFoundException
    }
}
