package com.fortech.demo.repository;

import com.fortech.demo.model.Retailer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerRepository extends CrudRepository<Retailer, Long> {

}
