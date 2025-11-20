package com.fortech.demo.dto;

import com.fortech.demo.model.Product;
import lombok.Data;

import java.util.Set;

@Data
public class NewRetailerResponse {
    private Long id;
    private String name;
    private String description;
    private Set<Product> products;
}
