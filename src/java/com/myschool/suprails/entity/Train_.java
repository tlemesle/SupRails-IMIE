/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myschool.suprails.entity;

import com.myschool.suprails.enumeration.Traction;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author thibault
 */
@StaticMetamodel(Train.class)
public class Train_ {
        public static volatile SingularAttribute<Train, Long> id;
        public static volatile SingularAttribute<Train, Traction> traction;
        public static volatile SingularAttribute<Train, Long> maxSpeed;

}
