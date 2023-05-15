package com.facturacion.facturacion.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.openxava.annotations.Required;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Room {
    @Id
    private int id;
    @Column(length = 50)
    @Required(message = "Tipo de habitacion")
    private String tipo;
    @Column(length = 50)    
    @Required
    private String descripcion;

    @OneToMany(mappedBy = "room")
    private List<Registro> registros;

}