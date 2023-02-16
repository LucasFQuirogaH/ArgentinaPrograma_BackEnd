package com.porfolio.lqfBackEnd.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersona {

    
    //Atributos -------------------------------------------------------------------------------------------------------------
    @NotBlank
    private String nombreCompleto;
    @NotBlank
    private String profesion;
    @NotBlank
    private String ubicacion;
    @NotBlank
    private String fotoPerfil;
    @NotBlank
    private String fotoPortada;
    //Atributos -------------------------------------------------------------------------------------------------------------
    
    //Constructores ---------------------------------------------------------------------------------------------------------

    public dtoPersona() {
    }
    public dtoPersona(String nombreCompleto, String profesion, String ubicacion, String fotoPerfil, String fotoPortada) {
        this.nombreCompleto = nombreCompleto;
        this.profesion = profesion;
        this.ubicacion = ubicacion;
        this.fotoPerfil = fotoPerfil;
        this.fotoPortada = fotoPortada;
    }
    //Constructores ---------------------------------------------------------------------------------------------------------
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getFotoPortada() {
        return fotoPortada;
    }

    public void setFotoPortada(String fotoPortada) {
        this.fotoPortada = fotoPortada;
    }
    //Constructores ---------------------------------------------------------------------------------------------------------
    
    

}
