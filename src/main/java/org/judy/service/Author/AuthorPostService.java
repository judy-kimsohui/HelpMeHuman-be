package org.judy.service.Author;

import org.judy.dto.Author.AuthorPostResponse;

public interface AuthorPostService {

    public AuthorPostResponse getAuthorPosts(Long authorId);

}
