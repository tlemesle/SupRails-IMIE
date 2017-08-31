/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myschool.suprails.dao;

import com.myschool.suprails.entity.CustomerOrder;

/**
 *
 * @author thibault
 */
public interface CustomerOrderDao {
    
    CustomerOrder addCustomerOrder(CustomerOrder order);
    
}
