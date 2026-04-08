package org.judy.service.User;


import lombok.RequiredArgsConstructor;
import org.judy.dto.User.*;
import org.judy.entity.User.User;
import org.judy.repository.User.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserRegisterServiceImpl implements UserRegisterService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserSignupResponse createUser(UserSignupRequest request) {
        User newUser = userRepository.save(new User(
                null,
                request.getUserName(),
                new ArrayList<>()
        ));
        return new UserSignupResponse(newUser.getUserName());
    }

    @Transactional(readOnly = true)
    @Override
    public UserInfoResponse getUserInfo(Long userId) {
        User userInfo = findUserById(userId);

        return new UserInfoResponse(userInfo.getUserName());
    }

    @Transactional
    @Override
    public UserUpdateResponse updateUser(Long userId, UserUpdateRequest request) {
        User updateUser = findUserById(userId);
        updateUser.update(request.getUserName());
        return new UserUpdateResponse(updateUser.getUserName());
    }

    @Transactional
    @Override
    public void deleteUser(Long userId) {
        User deleteUser = findUserById(userId);
        userRepository.delete(deleteUser);
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("일치하는 사용자 없음"));    // UserNotFoundException
    }
}
