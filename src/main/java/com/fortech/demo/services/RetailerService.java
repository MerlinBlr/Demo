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
        return mapper.toResponse(repository.findById(id)
                .orElseThrow(() -> new RetailerNotFoundException("Retailer not found for id: " + id)));
    }

    public List<Retailer> getRetailers() {
        return (List<Retailer>) repository.findAll();
    }

    // Dummy method to simulate adding a new retailer
    public String addDummyRetailer() {
        Retailer dummyRetailer = new Retailer();
        dummyRetailer.setName("Dummy Retailer");
        repository.save(dummyRetailer);
        return "Dummy retailer added successfully!";
    }

    // Dummy method to simulate updating a retailer's information
    public String updateDummyRetailer(Long id) {
        Retailer retailer = repository.findById(id)
                .orElseThrow(() -> new RetailerNotFoundException("Retailer not found for id: " + id));
        retailer.setName("Updated Dummy Retailer");
        repository.save(retailer);
        return "Retailer updated successfully!";
    }

    // Dummy method to simulate deleting a retailer
    public String deleteDummyRetailer(Long id) {
        repository.deleteById(id);
        return "Dummy retailer deleted successfully!";
    }

    // Dummy method to simulate fetching retailer names
    public List<String> getDummyRetailerNames() {
        return List.of("Retailer A", "Retailer B", "Retailer C");
    }
}
