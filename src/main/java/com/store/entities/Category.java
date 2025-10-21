/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.store.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ytchao
 */
@Entity(name = "category")
public class Category implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    
    public Category(){
        
    }
    
    public String getName(){
        return name;
    }
    public List<Product> getProduct(){
        return products;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setProduct(List<Product> products) {
        this.products = products;
    }
}
