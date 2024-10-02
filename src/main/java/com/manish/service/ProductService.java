package com.manish.service;

import com.manish.entity.Product;
import com.manish.model.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    Product getPrductById(Long id);
    List<ProductDto> getAllProducts();
    boolean deleteProduct(Long id);



}
