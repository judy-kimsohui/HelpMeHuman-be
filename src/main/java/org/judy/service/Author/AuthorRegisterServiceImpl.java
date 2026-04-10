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

    @Transactional(readOnly = true)
    @Override
    public AuthorInfoResponse getAuthorInfo(Long AuthorId) {
        Author authorInfo = findAuthorById(AuthorId);

        return new AuthorInfoResponse(authorInfo.getAuthorName());
    }

    @Transactional
    @Override
    public AuthorUpdateResponse updateAuthor(Long AuthorId, AuthorUpdateRequest request) {
        Author updateAuthor = findAuthorById(AuthorId);
        updateAuthor.update(request.getAuthorName());
        return new AuthorUpdateResponse(updateAuthor.getAuthorName());
    }

    @Transactional
    @Override
    public void deleteAuthor(Long AuthorId) {
        Author deleteAuthor = findAuthorById(AuthorId);
        authorRepository.delete(deleteAuthor);
    }

    private Author findAuthorById(Long AuthorId) {
        return authorRepository.findById(AuthorId)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 사용자 없음"));    // AuthorNotFoundException
    }
}
