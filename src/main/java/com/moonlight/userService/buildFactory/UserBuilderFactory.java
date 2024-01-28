package com.moonlight.userService.buildFactory;

import com.moonlight.userService.mappers.UserRequest;
import com.moonlight.userService.mappers.UserResponse;
import com.moonlight.userService.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserBuilderFactory {

    public User buildUserEntity(UserRequest request) {
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .middleName(request.getMiddleName())
                .mobileNumber(request.getMobileNumber())
                .email(request.getEmail())
                .build();
    }

    public UserResponse buildUserResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .middleName(user.getMiddleName())
                .mobileNumber(user.getMobileNumber())
                .build();
    }

    public void updateUser(User user, UserRequest request) {
        if (request.getEmail()!=null) {
            user.setEmail(request.getEmail());
        }
        if (request.getFirstName()!=null) {
            user.setFirstName(request.getFirstName());
        }
        if (request.getLastName()!=null) {
            user.setLastName(request.getLastName());
        }
        if (request.getMiddleName()!=null) {
            user.setMiddleName(request.getMiddleName());
        }
        if (request.getMobileNumber()!=null) {
            user.setMobileNumber(request.getMobileNumber());
        }
    }
}
