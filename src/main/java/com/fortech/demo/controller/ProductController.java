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

    @PostMapping("/random")
    public ResponseEntity<List<ProductResponse>> createRandomProducts() {
        try {
            List<ProductResponse> products = productService.createProductsFromAPI();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/stock")
    public ResponseEntity<Void> changeStockLevel(@RequestParam  RetailerName retailerName) {
        try {
            productService.increaseStockLevel(retailerName);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> searchProducts(@RequestParam  String text) {
        try {
            List<ProductResponse> products = productService.searchProducts(text);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}