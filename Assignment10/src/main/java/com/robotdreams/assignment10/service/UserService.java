package com.robotdreams.assignment10.service;

import com.robotdreams.assignment10.dto.UserRequestDto;
import com.robotdreams.assignment10.dto.UserResponseDto;
import com.robotdreams.assignment10.entity.User;
import com.robotdreams.assignment10.repository.UserRepository;
import com.robotdreams.assignment10.service.mapper.UserMapper;
import com.robotdreams.assignment10.service.sms.BlueSmsStrategy;
import com.robotdreams.assignment10.service.sms.HappySmsStrategy;
import com.robotdreams.assignment10.service.sms.SmsSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public boolean save(UserRequestDto userRequestDto) {

        User user = userMapper.userRequestDtoToUser(userRequestDto);
        userRepository.save(user);

        return user.getId() > 0;
    }

    public boolean update(long id, UserRequestDto userRequestDto) {

        var user = userRepository.findById(id);

        // Not Found
        if (user.isEmpty())
            return false;

        User updatedUser = userMapper.updateUser(user.get(), userRequestDto);
        userRepository.save(updatedUser);

        // Send Sms
        if (updatedUser.isPremium())
            new SmsSender(new HappySmsStrategy()).sendUserUpdatedSms(user.get());

        else
            new SmsSender(new BlueSmsStrategy()).sendUserUpdatedSms(user.get());

        return true;
    }

    public List<UserResponseDto> findAll() {

        List<User> user = userRepository.findAll();

        return user.stream().map(userMapper::userToUserResponseDto).toList();
    }

}
