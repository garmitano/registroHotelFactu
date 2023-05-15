package com.facturacion.facturacion.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.NoFrame;
import org.openxava.annotations.ReferenceView;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;
import org.openxava.annotations.View;
import org.openxava.calculators.CurrentLocalDateCalculator;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
@View(members = "date, room;" + "detalles")
public class Registro {

    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    @Stereotype("FECHA")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NoFrame
    @ReferenceView("simple")
    private Room room;

    @Column
    private boolean state;

    @ElementCollection
    @ListProperties("cliente.dni, cliente.name, cliente.location, obs")
    private List<Detalle> detalles;

}
