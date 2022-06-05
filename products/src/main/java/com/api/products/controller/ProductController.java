package com.api.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.api.products.dao.ProductRepository;
import com.api.products.entity.Product;
import com.api.products.hateoas.ProductModel;
import com.api.products.hateoas.ProductModelAssembler;
import org.springframework.data.web.PagedResourcesAssembler;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductModelAssembler productModelAssembler;

	@Autowired
	private PagedResourcesAssembler<Product> pagedRessourcesAssembler;

	@GetMapping("/products")
	@CrossOrigin
	public PagedModel<ProductModel> getAllProducts(
		@RequestParam(name="page", defaultValue = "0") Integer pageIndex,
		@RequestParam(name="size", defaultValue = "3") Integer pageSize
	) 
	{
		Page<Product> pagedProducts = productRepository.findAll(PageRequest.of(pageIndex, pageSize));
		return pagedRessourcesAssembler.toModel(pagedProducts, productModelAssembler);
	}

}