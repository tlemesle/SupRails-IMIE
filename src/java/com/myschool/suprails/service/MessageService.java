/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myschool.suprails.service;

import com.myschool.suprails.entity.CustomerOrder;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author thibault
 */
@Stateless
public class MessageService {
    
    @Resource(mappedName = "jms/SupRailsFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/SupRailsQueue")
    private Destination destination;


    public void sendMessageToPrinter(CustomerOrder order) throws JMSException{
        Connection cnx = connectionFactory.createConnection();
        Session session = cnx.createSession(false,Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(destination);
        ObjectMessage message = session.createObjectMessage(order);
        //message.setText("Your 'Microsoft' stock has been sold !");
        producer.send(message);			    
        cnx.close();
       
       }
}

