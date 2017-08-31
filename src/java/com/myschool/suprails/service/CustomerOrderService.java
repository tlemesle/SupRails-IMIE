/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myschool.suprails.service;

import com.myschool.suprails.dao.CustomerOrderDao;
import com.myschool.suprails.dao.TrainStationDao;
import com.myschool.suprails.entity.CustomerOrder;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author thibault
 */
@Stateless
public class CustomerOrderService {
    
    @EJB
    private CustomerOrderDao customerOrderDao;
    
    public CustomerOrder processCustomerOrder(CustomerOrder order){
        
        customerOrderDao.addCustomerOrder(order);
        return order;
    }
    
    @Asynchronous
    public void sendMail(String address){
        System.out.println("ENVOI MAIL A "+address);
    }
    
}
