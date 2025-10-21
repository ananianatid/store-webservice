/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.store.resource;

import com.store.entities.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;

import java.util.List;

/**
 *
 * @author ananianatid
 */

@Stateless
@Path("customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @PersistenceContext(unitName = "storePU")
    private EntityManager em;

   
    @GET
    public List<Customer> listAllCustomers() {
        return em.createQuery("SELECT c FROM Customer c", Customer.class)
                 .getResultList();
    }

 
    @POST
    public Customer createCustomer(Customer customer) {
        em.persist(customer);
        return customer;
    }
    

    @GET
    @Path("{id}") 
    public Customer getCustomerById(@PathParam("id") Long id) {
        return em.find(Customer.class, id);
    }
}
