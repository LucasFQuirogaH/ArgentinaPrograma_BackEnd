package com.porfolio.lqfBackEnd.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHys {

    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    //Constructor
    public dtoHys() {
    }

    public dtoHys(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    //Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

}
