package com.moonlight.userService.service;

import com.moonlight.userService.mappers.UserRequest;
import com.moonlight.userService.mappers.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse saveUser(UserRequest userRequest);

    UserResponse getUser(Integer userId);

    List<UserResponse> getAllUsers();

    String deleteUser(Integer userId);
    UserResponse updateUser(Integer userId, UserRequest userRequest);
}
