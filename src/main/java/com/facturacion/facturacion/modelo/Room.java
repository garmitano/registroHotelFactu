package com.facturacion.facturacion.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
@View(name = "simple", members = "id, tipo")
public class Room {
    @Id
    @Required
    private int id;
    @Column(length = 50)
    @Required(message = "Tipo de habitacion")
    private String tipo;
    @Column(length = 50)    
    private String descripcion;

    @OneToMany(mappedBy = "room")
    private List<Registro> registros;

}