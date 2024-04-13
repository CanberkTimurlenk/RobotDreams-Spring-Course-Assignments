package com.robotdreams.assignment7.service.mapper;

import com.robotdreams.assignment7.dto.OrderRequestDto;
import com.robotdreams.assignment7.entity.Order;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import com.robotdreams.assignment7.dto.OrderResponseDto;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {

    @Mapping(source = "orderNumber", target = "orderNumber")
    Order OrderRequestDtoToOrder(OrderRequestDto orderRequestDto);

    OrderResponseDto orderToOrderResponseDto(Order order);
}
