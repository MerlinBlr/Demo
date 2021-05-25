package com.fortech.demo.controller;

import com.fortech.demo.dto.RetailerResponse;
import com.fortech.demo.services.RetailerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/retailers", produces = MediaType.APPLICATION_JSON_VALUE)
public class RetailerController {

    private final RetailerService retailerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<RetailerResponse> getRetailer(@PathVariable Long id) {
        return ResponseEntity.ok(retailerService.getRetailerById(id));
    }
}
