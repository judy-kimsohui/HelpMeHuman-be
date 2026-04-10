package org.judy.dto.Author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.judy.entity.Post.Post;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorPostResponse {

    private List<Post> posts;
}
