package com.example.meu_primeiro_springboot.model;
import jakarta.persistence.*;

@Entity // indica que esta é uma classe JPA
@Table(name= "products") // Indica e define o nome da tabela
public class Product {
    @Id // Indica que este atributo ser o ID e único no banco de dados
    // Indica que o id será uma chave primária e será gerada automáticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    public Product() {}

    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
