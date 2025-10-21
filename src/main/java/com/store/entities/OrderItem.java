/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.store.entities;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author ytchao
 */
@Entity(name = "order_item")
public class OrderItem implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purcharseOrder;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    public OrderItem(){
        
    }
    
    public int getQuantity(){
        return quantity;
    }
    public PurchaseOrder getPurchaseOrder(){
        return purcharseOrder;
    }
    public Product getProduct(){
        return product;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setPurchaseOrder(PurchaseOrder purchaseOrder){
        this.purcharseOrder = purchaseOrder;
    } 
    public void setProduct(Product product){
        this.product = product;
    }
}
