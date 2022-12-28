package com.mpautasso.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@DiscriminatorValue("servicio")
public class Servicio extends Prestacion {

    public Servicio(String nombre, Double costo){
        super(nombre, costo);
    }

    @Override
    public String getType() {
        return "Servicio";
    }
    @Override
    public String toString(){
        return "Servicio(nombre = " + getNombre() + ", costo = " + getCosto() + ")";
    }
}