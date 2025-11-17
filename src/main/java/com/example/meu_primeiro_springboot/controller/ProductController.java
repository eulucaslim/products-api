package com.example.meu_primeiro_springboot.controller;

import com.example.meu_primeiro_springboot.exceptions.ResourceNotFoundException;
import com.example.meu_primeiro_springboot.model.Product;
import com.example.meu_primeiro_springboot.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> listAllProducts() {
        return  productService.listProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) {
        Product product = productService.getById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();

    }
}
