package com.facturacion.facturacion.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.openxava.annotations.Required;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Cliente {
    @Id
    @Required
    private int dni;
    @Column
    @Required
    private String name;
    @Column
    @Required
    private String location;
}