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
@StaticMetamodel(TrainStation.class)
public class TrainStation_ {
    public static volatile SingularAttribute<TrainStation, Long> id;
    public static volatile SingularAttribute<TrainStation, String> name;
    public static volatile SingularAttribute<TrainStation, String> address;
    public static volatile SingularAttribute<TrainStation, String> city;

}
