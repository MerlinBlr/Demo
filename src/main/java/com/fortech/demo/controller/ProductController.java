package com.fortech.demo.controller;

import com.fortech.demo.dto.ProductResponse;
import com.fortech.demo.services.ProductService;
import com.fortech.demo.util.RetailerName;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/random")
    public ResponseEntity<List<ProductResponse>> createRandomProducts() {
        return ResponseEntity.ok(productService.createProductsFromAPI());
    }

    @PutMapping(value = "/stock")
    public ResponseEntity<Void> changeStockLevel(@RequestParam RetailerName retailerName) {
        productService.increaseStockLevel(retailerName);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<ProductResponse>> searchProducts(@RequestParam String text) {
        return ResponseEntity.ok(productService.searchProducts(text));
    }

}
