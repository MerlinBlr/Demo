package com.fortech.demo.services;

import com.fortech.demo.dto.RetailerResponse;
import com.fortech.demo.util.exception.RetailerNotFoundException;
import com.fortech.demo.mapper.RetailerMapper;
import com.fortech.demo.model.Retailer;
import com.fortech.demo.repository.RetailerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetailerService {

    private final RetailerRepository repository;
    private final RetailerMapper mapper;

    public RetailerResponse getRetailerById(Long id) {
        return   mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new RetailerNotFoundException("Retailer not found for id: " + id)));
    }

    public List<Retailer> getRetailers() {
        return (List<Retailer>) repository.findAll();
    }

}
