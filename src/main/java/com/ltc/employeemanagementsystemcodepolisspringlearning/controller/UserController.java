package com.ltc.employeemanagementsystemcodepolisspringlearning.controller;

import com.ltc.employeemanagementsystemcodepolisspringlearning.dto.request.UserRequest;
import com.ltc.employeemanagementsystemcodepolisspringlearning.dto.response.UserResponse;
import com.ltc.employeemanagementsystemcodepolisspringlearning.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller",description = "User-in CRUD emeliyyati")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid  UserRequest userRequest) {

        UserResponse user = userService.createUser(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
