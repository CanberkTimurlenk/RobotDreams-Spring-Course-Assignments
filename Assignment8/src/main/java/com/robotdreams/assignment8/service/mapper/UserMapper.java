package com.robotdreams.assignment8.service.mapper;

import com.robotdreams.assignment8.dto.UserRequestDto;
import com.robotdreams.assignment8.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    User userRequestDtoToUser(UserRequestDto dto);
}
