package com.fortech.demo.dto;

import com.fortech.demo.model.Retailer;
import lombok.Data;

import java.util.Set;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Long stockLevel;
    private Set<Retailer> retailers;
}
