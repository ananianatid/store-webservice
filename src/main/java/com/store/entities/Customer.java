package com.store.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    
    @OneToMany(mappedBy = "customer")
    private List<PurchaseOrder> purchaseOrders;
    
    public Customer() {
    }
    
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

}