package com.paracasa.spring.app.model;

import javax.persistence.*;

@Entity
@Table(name= "Ordenadores")

public class Ordenadores {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;

    private String description;

    private double price;


    public Ordenadores(String name, String description, double price) {
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
    }

    public Ordenadores(){

    }

    public Long getId() {return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }

    public void setPrice (double price) { this.price = price; }
}