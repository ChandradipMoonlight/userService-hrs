package com.moonlight.userService.service;


import com.moonlight.commonutility.exception.ResourceNotFoundException;
import com.moonlight.userService.buildFactory.UserBuilderFactory;
import com.moonlight.userService.dto.UserRequest;
import com.moonlight.userService.dto.UserResponse;
import com.moonlight.userService.entity.User;
import com.moonlight.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBuilderFactory userBuilderFactory;

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user = userBuilderFactory.buildUserEntity(userRequest);
        User saved = userRepository.save(user);
        return userBuilderFactory.buildUserResponse(saved);
    }

    @Override
    public UserResponse getUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new com.moonlight.commonutility.exception.ResourceNotFoundException("User", "UserId", String.valueOf(userId)));
        return userBuilderFactory.buildUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> userBuilderFactory.buildUserResponse(user))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteUser(Integer userId) {
        userRepository.deleteById(userId);
        return "User Deleted Successfully!";
    }

    @Override
    public UserResponse updateUser(Integer userId, UserRequest userRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "UserId", String.valueOf(userId)));
        userBuilderFactory.updateUser(user, userRequest);
        User updated = userRepository.save(user);
        return userBuilderFactory.buildUserResponse(updated);
    }

}
