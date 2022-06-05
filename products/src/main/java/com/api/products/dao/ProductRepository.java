package com.api.products.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.products.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{

    Page<Product> findAll(Pageable pageable);
}
