package com.porfolio.lqfBackEnd.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyectos {

    // Atributos -----------------------------------------------
    @NotBlank
    private String nombre;
    @NotBlank
    private String fotoDescripcion;
    @NotBlank
    private String link;
    // Atributos -----------------------------------------------

    // Constructores  ------------------------------------------
    public dtoProyectos() {
    }

    public dtoProyectos(String nombre, String fotoDescripcion, String link) {
        this.nombre = nombre;
        this.fotoDescripcion = fotoDescripcion;
        this.link = link;
    }

    // Constructores  ------------------------------------------
    
    // Getters & Setters  --------------------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotoDescripcion() {
        return fotoDescripcion;
    }

    public void setFotoDescripcion(String fotoDescripcion) {
        this.fotoDescripcion = fotoDescripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    // Getters & Setters  --------------------------------------

}
