package org.judy.service.User;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.judy.dto.User.UserPostResponse;
import org.judy.entity.Post.Post;
import org.judy.entity.User.User;
import org.judy.repository.Post.PostRepository;
import org.judy.repository.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPostSreviceImpl implements UserPostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    @Override
    public UserPostResponse getUserPosts(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 사용자 없음"));

        List<Post> posts = user.getPosts();
        return new UserPostResponse(posts);
    }

}
