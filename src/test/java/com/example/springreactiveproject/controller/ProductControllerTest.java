package com.example.springreactiveproject.controller;



import com.example.springreactiveproject.model.Product;
import com.example.springreactiveproject.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class ProductControllerTest {

    private final ProductService productService = Mockito.mock(ProductService.class);
    private final WebTestClient webTestClient = WebTestClient.bindToController(new ProductController(productService)).build();

    @Test
    void testGetProductsByEan() {
        Product product = new Product();
        product.setEan("123456789");
        product.setStoreId("1");
        product.setName("Produit A");
        product.setPrice(10.0);

        Mockito.when(productService.getProductsByEan("123456789")).thenReturn(Flux.just(product));

        webTestClient.get()
                .uri("/products/ean/123456789")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Product.class)
                .hasSize(1);
    }

    @Test
    void testGetProductByEanAndStoreId() {
        Product product = new Product();
        product.setEan("123456789");
        product.setStoreId("1");
        product.setName("Produit B");
        product.setPrice(15.0);

        Mockito.when(productService.getProductByEanAndStoreId("123456789", "1")).thenReturn(Mono.just(product));

        webTestClient.get()
                .uri("/products/ean/123456789/store/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Product.class);
    }
}

