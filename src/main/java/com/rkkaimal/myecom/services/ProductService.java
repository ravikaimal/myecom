package com.rkkaimal.myecom.services;

import com.rkkaimal.myecom.exceptions.ProductNotFoundException;
import com.rkkaimal.myecom.model.Product;
import com.rkkaimal.myecom.data.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        List<Product> result =  productRepository.findAll();
        return result;
    }

    public List<Product> search(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public Product findById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}