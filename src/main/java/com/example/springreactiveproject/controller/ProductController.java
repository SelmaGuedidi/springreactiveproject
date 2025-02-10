package com.example.springreactiveproject.controller;


import com.example.springreactiveproject.model.Product;
import com.example.springreactiveproject.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products/ean")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{ean}")
    public Flux<Product> getProductsByEan(@PathVariable String ean) {
        return productService.getProductsByEan(ean);
    }

    @GetMapping("/{ean}/store/{storeId}")
    public Mono<Product> getProductByEanAndStoreId(@PathVariable String ean, @PathVariable String storeId) {
        return productService.getProductByEanAndStoreId(ean, storeId);
    }
}
