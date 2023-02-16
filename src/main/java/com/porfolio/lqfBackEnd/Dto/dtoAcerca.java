package com.porfolio.lqfBackEnd.Dto;

import javax.validation.constraints.NotBlank;

public class dtoAcerca {

    @NotBlank
    private String descripcion;
    
    //Constructor
    public dtoAcerca() {
    }

    public dtoAcerca(String descripcion) {
        this.descripcion = descripcion;
    }
    
    //Getters y Setters

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
