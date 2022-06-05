package com.api.products.hateoas;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.api.products.controller.ProductController;
import com.api.products.entity.Product;

@Component
public class ProductModelAssembler extends RepresentationModelAssemblerSupport<Product, ProductModel> {

	public ProductModelAssembler() {
		super(ProductController.class, ProductModel.class);
	}

	@Override
	public ProductModel toModel(Product entity) {
        ProductModel model = new ProductModel();
        BeanUtils.copyProperties(entity, model);
        return model;
	}
    
}
