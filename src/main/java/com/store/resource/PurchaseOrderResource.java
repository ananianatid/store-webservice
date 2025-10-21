/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.store.resource;

import com.store.entities.PurchaseOrder;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import com.store.entities.Customer;
import com.store.entities.OrderItem;
import com.store.entities.Product;

/**
 *
 * @author ananianatid
 */


@Stateless
@Path("purchaseorders")
// ...
public class PurchaseOrderResource {
    @PersistenceContext(unitName = "storePU")
    private EntityManager em;
    @POST
    public PurchaseOrder createOrder(PurchaseOrder order) {
        if (order.getCustomer() != null && order.getCustomer().getId() != 0) {
            Customer managedCustomer = em.find(Customer.class, order.getCustomer().getId());
            order.setCustomer(managedCustomer);
        }

        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                
                item.setPurchaseOrder(order); 
                
                if (item.getProduct() != null && item.getProduct().getId() != 0) {
                    Product managedProduct = em.find(Product.class, item.getProduct().getId());
                    item.setProduct(managedProduct);
                }
            }
        }
        em.persist(order);
        
        return order;
    }
}