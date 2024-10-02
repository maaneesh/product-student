package com.manish.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;
    @Column(name= "name", nullable = false)
    private String name;
    @Column(name ="quantity", nullable = false)
    private int quantity;
    @Column(name = "price", nullable = false)
    private float price;

    public Product(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
