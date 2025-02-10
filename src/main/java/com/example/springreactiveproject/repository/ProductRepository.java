package com.example.springreactiveproject.repository;

import com.example.springreactiveproject.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    Flux<Product> findByEan(String ean);
    Mono<Product> findByEanAndStoreId(String ean, String storeId);
}