/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myschool.suprails.entity;

import com.myschool.suprails.enumeration.Traction;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author thibault
 */
@Entity
@DiscriminatorValue(value="PASSENGER")

public class PassengerTrain extends Train implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @NotNull
    private Traction traction;
    
    @NotNull
    @Column(nullable=false)
    private Long maxSpeed;
    
    @NotNull
    @Column(nullable=false)
    private Integer seatQuantity;

    public PassengerTrain() {
    }

    public PassengerTrain(Traction traction, Long maxSpeed, Integer seatQuantity) {
        this.traction = traction;
        this.maxSpeed = maxSpeed;
        this.seatQuantity = seatQuantity;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Traction getTraction() {
        return traction;
    }

    public void setTraction(Traction traction) {
        this.traction = traction;
    }

    
    
    public Long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getSeatQuantity() {
        return seatQuantity;
    }

    public void setSeatQuantity(Integer seatQuantity) {
        this.seatQuantity = seatQuantity;
    }
    
    
    
}
