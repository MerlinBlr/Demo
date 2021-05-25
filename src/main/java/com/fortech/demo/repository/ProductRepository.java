package com.fortech.demo.repository;

import com.fortech.demo.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Modifying
    @Query(value="UPDATE  product p SET p.stock_level = p.stock_level + :stockLevel " +
            "WHERE  p.id in (SELECT rpr.product_id from retailer_product_relation rpr " +
            "INNER JOIN retailer r ON (rpr.retailer_id = r.id) where r.name= :retailerName) ", nativeQuery=true)
    void updateProductByRetailerName(@Param("retailerName") String retailerName, @Param("stockLevel") Integer stockLevel);

    List<Product> findByNameContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String name, String description);

}
