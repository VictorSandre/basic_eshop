package com.api.products.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;;

@Entity
public class Product {
    
    @Id
    @GeneratedValue
    private Long id;

    private String image;

    private Double price;

    private String title;

    protected Product() {}

    public Product(String image, Double price, String title) {
        this.image = image;
        this.price = price;
        this.title = title;
    }

    public Long getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getTitle() {
        return this.title;
    }
}
