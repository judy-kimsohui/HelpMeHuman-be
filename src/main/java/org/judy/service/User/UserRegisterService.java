package org.judy.service.User;

import org.judy.dto.User.*;

public interface UserRegisterService {

    public UserSignupResponse createUser(UserSignupRequest request);

    public UserUpdateResponse updateUser(Long userId, UserUpdateRequest request);

    public void deleteUser(Long userId);

    public UserInfoResponse getUserInfo(Long userId);

    // public void getAllUsers();

}
