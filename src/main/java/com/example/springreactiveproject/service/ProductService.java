package com.example.springreactiveproject.service;

import com.example.springreactiveproject.model.Product;
import com.example.springreactiveproject.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> getProductsByEan(String ean) {
        return productRepository.findByEan(ean);
    }

    public Mono<Product> getProductByEanAndStoreId(String ean, String storeId) {
        return productRepository.findByEanAndStoreId(ean, storeId);
    }
}