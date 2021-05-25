package com.fortech.demo.mapper;

import com.fortech.demo.dto.RetailerResponse;
import com.fortech.demo.model.Retailer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RetailerMapper {

    RetailerResponse toResponse(Retailer retailer);

}
