package com.fortech.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_product")
    @SequenceGenerator(name = "seq_product", sequenceName = "seq_product", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(name="stock_level")
    private Long stockLevel;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Retailer> retailers = new HashSet<>();

    public Set<Retailer> getRetailers() {
         return new HashSet<>(retailers);
    }

    public void addRetailer(Retailer retailer) {
        if (retailers.contains(retailer)) return;
        retailers.add(retailer);
    }
}
