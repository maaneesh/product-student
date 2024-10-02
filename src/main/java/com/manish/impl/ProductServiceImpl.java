package com.manish.impl;

import com.manish.entity.Product;
import com.manish.model.ProductDto;
import com.manish.repo.ProductRepo;
import com.manish.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDto createProduct(ProductDto product) {
        Product newProduct = new Product();
        BeanUtils.copyProperties(product, newProduct);

        Product saveEnt = productRepo.save(newProduct);

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(saveEnt, productDto);
        return productDto;

    }

    @Override
    public Product getPrductById(Long id) {
        Optional<Product> productId = productRepo.findById(id);
        return productId.get();

    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productRecords = productRepo.findAll();
        List<ProductDto> viewRecords = new ArrayList<ProductDto>();

        for (Product product : productRepo.findAll()) {
            ProductDto newProduct = new ProductDto();
            BeanUtils.copyProperties(product, newProduct);
            viewRecords.add(newProduct);
        }
        return viewRecords;
    }

    @Override
    public boolean deleteProduct(Long id) {
        boolean flag = false;
        Product product = productRepo.findById(id).get();
        if (product != null) {
            productRepo.delete(product);
            flag = true;
        }
        return flag;
    }
}
