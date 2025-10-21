/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.store.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ananianatid
 */
@Entity(name = "purchase_order")
public class PurchaseOrder implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.PERSIST)
    private List<OrderItem> orderItems;
    
    public PurchaseOrder() {
        
    }
    
    public int getId(){
        return id;
    }
    public LocalDate getDate(){
        return date;
    }
    public OrderStatus getStatus(){
        return status;
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void setDate(LocalDate date){
        this.date = date;
    }
    public void setStatus(OrderStatus status){
        this.status = status;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    public void setId(int id){
        this.id = id;
    }
}
