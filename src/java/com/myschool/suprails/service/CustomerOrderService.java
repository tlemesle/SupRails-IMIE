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
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author thibault
 */
@Stateless
public class CustomerOrderService {
    
    @EJB
    private CustomerOrderDao customerOrderDao;
    @EJB
    private MessageService messageService;
    
    public CustomerOrder processCustomerOrder(CustomerOrder order) throws JMSException{
        
        customerOrderDao.addCustomerOrder(order);
        messageService.sendMessageToPrinter(order);
        return order;
    }
    
    @Asynchronous
    public void sendMail(String address){
        System.out.println("ENVOI MAIL A "+address);
    }
    
}
