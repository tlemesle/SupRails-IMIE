/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myschool.suprails.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author thibault
 */
@StaticMetamodel(CustomerOrder.class)
public class CustomerOrder_ {
    public static volatile SingularAttribute<CustomerOrder, Long> id;
    public static volatile SingularAttribute<CustomerOrder, Customer> customer;
    public static volatile SingularAttribute<CustomerOrder, Trip> trip;

}
