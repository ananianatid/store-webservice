/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.store.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
* @author ananianatid

 */
@Entity(name = "order_item")
public class OrderItem implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    @JsonbTransient
    private PurchaseOrder purchaseOrder;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    public OrderItem(){
        
    }
    
    public int getId(){
        return id;
    }
    public int getQuantity(){
        return quantity;
    }
    public PurchaseOrder getPurchaseOrder(){
        return purchaseOrder;
    }
    public Product getProduct(){
        return product;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setPurchaseOrder(PurchaseOrder purchaseOrder){
        this.purchaseOrder = purchaseOrder;
    } 
    public void setProduct(Product product){
        this.product = product;
    }
}
