package com.robotdreams.assignment10.service.mapper;

import com.robotdreams.assignment10.dto.OrderRequestDto;
import com.robotdreams.assignment10.entity.Order;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import com.robotdreams.assignment10.dto.OrderResponseDto;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {

    Order OrderRequestDtoToOrder(OrderRequestDto orderRequestDto);

    OrderResponseDto orderToOrderResponseDto(Order order);
}
