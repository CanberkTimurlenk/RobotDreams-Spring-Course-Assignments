package com.robotdreams.assignment11.controller;

import com.robotdreams.assignment11.dto.UserRequestDto;
import com.robotdreams.assignment11.dto.UserResponseDto;
import com.robotdreams.assignment11.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserRequestDto userRequestDto) {

        return userService.save(userRequestDto)
                ? new ResponseEntity<>("Successfully Created!", HttpStatus.CREATED)
                : new ResponseEntity<>("An Unexpected Error Occured!", HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> update(@PathVariable long userId, @RequestBody UserRequestDto userRequestDto) {

        return userService.update(userId, userRequestDto)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

}
