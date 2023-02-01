package com.rkkaimal.myecom.controller;

import com.rkkaimal.myecom.exceptions.ProductNotFoundException;
import com.rkkaimal.myecom.model.Product;
import com.rkkaimal.myecom.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name) {
        return productService.search(name);
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.findById(id);
    }

    @PostMapping("/products")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }
}
