package org.judy.service.User;

import org.judy.dto.User.UserPostResponse;
import org.judy.dto.User.UserSignupRequest;
import org.judy.dto.User.UserSignupResponse;

public interface UserPostService {

    public UserPostResponse getUserPosts(Long userId);

}
