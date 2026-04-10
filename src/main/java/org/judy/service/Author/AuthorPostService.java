package org.judy.service.Author;

import org.judy.dto.Author.AuthorPostResponse;
import org.judy.entity.Post.Post;

import java.util.List;

public interface AuthorPostService {

    public List<Post> getAuthorPosts(Long authorId);

}
