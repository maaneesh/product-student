package com.manish.rest;

import com.manish.entity.Product;
import com.manish.impl.ProductServiceImpl;
import com.manish.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productImpl;

    @PostMapping("/product")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto product) {
        ProductDto productInfo = productImpl.createProduct(product);
        return new ResponseEntity<>(productInfo, HttpStatus.CREATED);

    }

    //Get all students API
    @GetMapping(value = "/view")
    public ResponseEntity<?> getProducts() {
        List<ProductDto> allProducts = productImpl.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    //Build get Product by id API
    @GetMapping("/byId/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productImpl.getPrductById(id);
    }

    //Delete item by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id) {
        boolean deleteProduct = productImpl.deleteProduct(id);
        if (deleteProduct) {
            return new ResponseEntity<>("Product deleted", HttpStatus.OK);

        } else return new ResponseEntity<>("Product does not exist", HttpStatus.OK);

    }


}
