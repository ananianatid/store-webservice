/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.store.resource;

import com.store.entities.Category;
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
@Path("categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {
    @PersistenceContext(unitName = "storePU")
    private EntityManager em;
    
    @GET
    public List<Category> listAllCategories() {
        return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }
    
    @POST
    public Category createCategory(Category category) {
        em.persist(category);
        return category;
    }
    
}
