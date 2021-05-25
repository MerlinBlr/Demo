package com.fortech.demo.mapper;

import com.fortech.demo.dto.ProductResponse;
import com.fortech.demo.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponse toResponse(Product product);

}
