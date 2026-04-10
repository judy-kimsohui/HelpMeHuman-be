package org.judy.service.Author;

import org.judy.dto.Author.*;
import org.judy.entity.Post.Post;

import java.util.List;

public interface AuthorRegisterService {

    public AuthorSignupResponse createAuthor(AuthorSignupRequest request);

    public AuthorUpdateResponse updateAuthor(Long authorId, AuthorUpdateRequest request);

    public void deleteAuthor(Long authorId);

    public AuthorInfoResponse getAuthorInfo(Long authorId);

    // public void getAllAuthors();

}
