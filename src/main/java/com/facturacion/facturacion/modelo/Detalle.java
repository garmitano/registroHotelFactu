package com.facturacion.facturacion.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Embeddable @Getter @Setter
public class Detalle {

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Cliente cliente;
    @Column
    private String obs;
    
}
