package com.paracasa.spring.app.model;

import javax.persistence.*;

@Entity
@Table(name= "Pedidos")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String size;

    private String address;

    private double weight;

    public Pedidos(String size, String address, double weight) {
        this.setSize(size);
        this.setAddress(address);
        this.setWeight(weight);
    }

    public Pedidos() {

    }

    public Long getId() {return id; }

    public void setId(Long id) { this.id = id; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public double getWeight() { return weight; }

    public void setWeight (double weight) { this.weight = weight; }
}