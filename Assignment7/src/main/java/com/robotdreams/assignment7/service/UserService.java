package com.robotdreams.assignment7.service;

import com.robotdreams.assignment7.dto.UserRequestDto;
import com.robotdreams.assignment7.entity.User;
import com.robotdreams.assignment7.repository.UserRepository;
import com.robotdreams.assignment7.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Optional<User> findById(long  id){
        return userRepository.findById(id);
    }

    public boolean save(UserRequestDto userRequestDto) {

        User user = userMapper.userRequestDtoToUser(userRequestDto);
        userRepository.save(user);

        return user.getId() > 0;
    }
}
