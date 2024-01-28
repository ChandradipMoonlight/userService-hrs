package com.moonlight.userService.controller;

import com.moonlight.commonutility.mappers.AppResponse;
import com.moonlight.userService.dto.UserRequest;
import com.moonlight.userService.dto.UserResponse;
import com.moonlight.userService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<AppResponse> createUser(@RequestBody @Valid UserRequest userRequest) {
        UserResponse userResponse = userService.saveUser(userRequest);
        return ResponseEntity.ok().body(new AppResponse(userResponse));
    }

    @GetMapping(value = "/get/{userId}")
    public ResponseEntity<AppResponse> getUserDetails(@PathVariable Integer userId) {
        UserResponse userResponse = userService.getUser(userId);
        return ResponseEntity.ok().body(new AppResponse(userResponse));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<AppResponse> getAllUsers() {
        return ResponseEntity.ok()
                .body(new AppResponse(userService.getAllUsers()));
    }

    @PutMapping(value = "/update/{userId}")
    public ResponseEntity<AppResponse> updateUser(@PathVariable Integer userId, @RequestBody @Valid UserRequest request) {
        return ResponseEntity.ok()
                .body(new AppResponse(userService.updateUser(userId, request)));
    }

    @DeleteMapping(value = "/delete/{userId}")
    public ResponseEntity<AppResponse> deleteUser(@PathVariable Integer userId) {
        return ResponseEntity.ok()
                .body(new AppResponse(userService.deleteUser(userId)));
    }

}
