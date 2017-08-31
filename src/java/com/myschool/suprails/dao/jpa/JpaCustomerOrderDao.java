/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myschool.suprails.dao.jpa;

import com.myschool.suprails.dao.CustomerOrderDao;
import com.myschool.suprails.entity.CustomerOrder;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thibault
 */
@Stateless
public class JpaCustomerOrderDao implements CustomerOrderDao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public CustomerOrder addCustomerOrder(CustomerOrder order) {
        em.persist(order);
        return order;
    }

    
    
}
