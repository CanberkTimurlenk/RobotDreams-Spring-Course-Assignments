package com.robotdreams.assignment11.service.mapper;

import com.robotdreams.assignment11.dto.ProductDetailRequestDto;
import com.robotdreams.assignment11.entity.ProductDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductDetailMapper {
    ProductDetailMapper INSTANCE = Mappers.getMapper(ProductDetailMapper.class);

    ProductDetail mapToProductDetail(ProductDetailRequestDto dto);
}
