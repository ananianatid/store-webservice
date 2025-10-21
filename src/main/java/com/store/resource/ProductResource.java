/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.store.resource;

import com.store.entities.Product;
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
@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @PersistenceContext(unitName = "storePU")
    private EntityManager em;

   
    @GET
    public List<Product> listAllProducts() {
        return em.createQuery("SELECT p FROM Product p", Product.class)
                 .getResultList();
    }

    @POST
    public Product createProduct(Product product) {
        em.persist(product);
        return product;
    }
    
    // Méthode pour l'URL: GET /api/products/1
    @GET
    @Path("{id}")
    public Product getProductById(@PathParam("id") int id) {
        return em.find(Product.class, id);
    }
    

    @PUT
    @Path("{id}")
    public Product updateProduct(@PathParam("id") int id, Product productToUpdate) {
        productToUpdate.setId(id);
        
        
        Product updatedProduct = em.merge(productToUpdate);
        
        return updatedProduct;
    }
}