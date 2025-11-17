package com.example.meu_primeiro_springboot.service;

import com.example.meu_primeiro_springboot.exceptions.ResourceNotFoundException;
import com.example.meu_primeiro_springboot.model.Product;
import com.example.meu_primeiro_springboot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto com ID " +id+" não encontrado!"));
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){

        if (!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Product with ID" + id + "Not Found!");
        }
        productRepository.deleteById(id);
    }
}
