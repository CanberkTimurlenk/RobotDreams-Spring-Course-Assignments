package com.robotdreams.assignment7.service.mapper;

import com.robotdreams.assignment7.dto.ProductDetailRequestDto;
import com.robotdreams.assignment7.dto.ProductRequestDto;
import com.robotdreams.assignment7.dto.ProductResponseDto;
import com.robotdreams.assignment7.entity.Product;
import com.robotdreams.assignment7.entity.ProductDetail;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {

    @Mapping(target = "productDetail", source = "productDetail", qualifiedByName = "mapToProductDetail")
    Product mapToProduct(ProductRequestDto dto);

    ProductResponseDto productToProductResponseDto(Product product);

    @Named("mapToProductDetail")
    default ProductDetail mapToProductDetail(ProductDetailRequestDto dto) {
        return ProductDetailMapper.INSTANCE.mapToProductDetail(dto);
    }

    @AfterMapping
    default void afterMapping(@MappingTarget Product product) {
        var detail = product.getProductDetail();
        detail.setProduct(product);
    }

}
