package com.paracasa.spring.app.model;

import javax.persistence.*;

@Entity
@Table(name= "Componentes")

public class Componentes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;

    private String description;

    private double price;

    private String type;

    public Componentes(String name, String description, double price, String type) {
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setType(type);
    }

    public Componentes() {

    }

    public Long getId() {return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getType(){ return type; }

    public void setType(String type){ this.type = type;}

    public double getPrice() { return price; }

    public void setPrice (double price) { this.price = price; }
}