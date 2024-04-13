package com.robotdreams.assignment10.service.mapper;

import com.robotdreams.assignment10.dto.UserRequestDto;
import com.robotdreams.assignment10.dto.UserResponseDto;
import com.robotdreams.assignment10.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    User userRequestDtoToUser(UserRequestDto dto);

    User updateUser(@MappingTarget User user, UserRequestDto dto);

    UserResponseDto userToUserResponseDto(User user);
}
