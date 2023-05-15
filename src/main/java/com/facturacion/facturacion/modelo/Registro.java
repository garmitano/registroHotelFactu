package com.facturacion.facturacion.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Required;
import org.openxava.calculators.CurrentLocalDateCalculator;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Registro {

    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    private LocalDate date;

    @ManyToOne
    private Room room;

    @Column
    private boolean state;

    @ElementCollection
    @ListProperties("cliente.dni, cliente.name, cliente.location, obs")
    private List<Detalle> detalles;

}
