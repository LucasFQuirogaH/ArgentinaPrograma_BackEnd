
package com.porfolio.lqfBackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {
    
    // Atributos -----------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String fotoDescripcion;
    private String link;
    // Atributos -----------------------------------------
    
    // Constructores -------------------------------------
    public Proyectos() { 
    }

    public Proyectos(String nombre, String fotoDescripcion, String link) {
        this.nombre = nombre;
        this.fotoDescripcion = fotoDescripcion;
        this.link = link;
    }
    // Constructores -------------------------------------
    
    // Getters & Setters  --------------------------------
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    // Getters & Setters  --------------------------------
    
    
    
}
