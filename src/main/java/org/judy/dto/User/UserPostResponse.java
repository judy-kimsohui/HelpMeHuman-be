package org.judy.dto.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.judy.entity.Post.Post;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserPostResponse {

    private List<Post> posts;
}
