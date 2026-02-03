package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    private String name;

    private String email;

    private String password;

    private String phone;


    // ================= Constructors =================

    public Customer() {
        super();
    }

    public Customer(Integer customerId, String name, String email,
                    String password, String phone) {

        super();
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }


    // ================= Getters & Setters =================

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }


    // ================= toString() =================

    @Override
    public String toString() {

        return "Customer [customerId=" + customerId +
                ", name=" + name +
                ", email=" + email +
                ", password=" + password +
                ", phone=" + phone +
                "]";
    }

}