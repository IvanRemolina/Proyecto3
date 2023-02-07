package com.paracasa.spring.app.model;

import javax.persistence.*;

@Entity
@Table(name= "Clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;

    private String mail;

    private String phone;

    private String login;

    public Clientes(String name, String mail, String login) {
        this.setName(name);
        this.setMail(mail);
        this.setLogin(login);
    }

    public Clientes() {

    }

    public Long getId() {return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getMail() { return mail; }

    public void setMail(String mail) { this.mail = mail; }

    public String getPhone(){ return phone; }

    public void setPhone(String phone){ this.phone = phone;}

    public String getLogin() { return login; }

    public void setLogin (String login) { this.login = login; }
}