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
@Table(name = "retailer")
public class Retailer implements Serializable {

    //todo do not forget to remove fddfsdfs

    @Id
    @GeneratedValue(generator = "seq_retailer")
    @SequenceGenerator(name = "seq_retailer", sequenceName = "seq_retailer", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "retailer_product_relation",
            joinColumns = @JoinColumn(name = "retailer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Product> products = new HashSet<>();

    public Set<Product> getProducts() {
        return new HashSet<>(products);
    }

    public void addProduct(Product product) {
        if (products.contains(product)) return;
        products.add(product);
    }

}
