package com.example.springreactiveproject.service;

import com.example.springreactiveproject.model.Product;
import com.example.springreactiveproject.repository.ProductRepository;
import com.example.springreactiveproject.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class ProductServiceTest {

    private final ProductRepository productRepository = mock(ProductRepository.class);
    private final ProductService productService = new ProductService(productRepository);

    @Test
    void testGetProductsByEan() {
        Product product1 = new Product();
        product1.setEan("123456789");
        product1.setStoreId("1");
        product1.setName("Produit A");
        product1.setPrice(10.0);

        when(productRepository.findByEan("123456789")).thenReturn(Flux.just(product1));

        StepVerifier.create(productService.getProductsByEan("123456789"))
                .expectNext(product1)
                .verifyComplete();
    }

    @Test
    void testGetProductByEanAndStoreId() {
        Product product = new Product();
        product.setEan("123456789");
        product.setStoreId("1");
        product.setName("Produit B");
        product.setPrice(15.0);

        when(productRepository.findByEanAndStoreId("123456789", "1")).thenReturn(Mono.just(product));

        StepVerifier.create(productService.getProductByEanAndStoreId("123456789", "1"))
                .expectNext(product)
                .verifyComplete();
    }
}
