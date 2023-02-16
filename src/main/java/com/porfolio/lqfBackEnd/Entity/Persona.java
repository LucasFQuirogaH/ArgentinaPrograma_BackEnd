package com.porfolio.lqfBackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Persona {

//    ----------------------------------------------   Atributos  -------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nombreCompleto;

    @NotNull
    private String profesion;

    @NotNull
    private String ubicacion;
    private String fotoPerfil;
    private String fotoPortada;
//    ----------------------------------------------   Atributos  -------------------------------------------------------
    
    
//    --------------------------------------------   Constructores -----------------------------------------------------
    public Persona() {
    }

    public Persona(String nombreCompleto, String profesion, String ubicacion, String fotoPerfil, String fotoPortada) {
        this.nombreCompleto = nombreCompleto;
        this.profesion = profesion;
        this.ubicacion = ubicacion;
        this.fotoPerfil = fotoPerfil;
        this.fotoPortada = fotoPortada;
    }
//    --------------------------------------------   Constructores -----------------------------------------------------
    
//    --------------------------------------------   Getters & Setters -------------------------------------------------
  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

//    --------------------------------------------   Getters & Setters -------------------------------------------------

  

    
}
