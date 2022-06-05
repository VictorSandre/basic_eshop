package com.api.products.hateoas;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "products", itemRelation = "product")
public class ProductModel extends RepresentationModel<ProductModel> {
    
    private Long id;
    
    private String image;
    
    private Double price;
    
    private String title;

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
