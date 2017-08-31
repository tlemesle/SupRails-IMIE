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
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="trainType")
public abstract class Train implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    
    @Enumerated(EnumType.STRING)
    @NotNull
    private Traction traction;

    @NotNull
    @Column(nullable=false)
    private Long maxSpeed;

    public Train() {
    }

    public Train(Traction traction, Long maxSpeed) {
        this.traction = traction;
        this.maxSpeed = maxSpeed;
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
    
    
    
}
