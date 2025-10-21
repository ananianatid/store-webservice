/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.store.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

/**
 *
 * @author ytchao
 */
@Entity(name = "product")
public class Product {
    private int id;
    private String name;
    private Double price;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;
    
    public Product(){
        
    }
    
    public String getName(){
        return name;
    }
    public Double getPrice(){
        return price;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
