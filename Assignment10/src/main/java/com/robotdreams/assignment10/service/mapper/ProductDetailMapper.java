package com.robotdreams.assignment10.service.mapper;

import com.robotdreams.assignment10.dto.ProductDetailRequestDto;
import com.robotdreams.assignment10.entity.ProductDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductDetailMapper {
    ProductDetailMapper INSTANCE = Mappers.getMapper(ProductDetailMapper.class);

    ProductDetail mapToProductDetail(ProductDetailRequestDto dto);
}
