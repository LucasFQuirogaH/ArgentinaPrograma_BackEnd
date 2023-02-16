package com.porfolio.lqfBackEnd.Security.Controller;


public class Mensaje {
    public String mensaje;
    
    //Constructor
    public Mensaje(){
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    //Getters y Setters

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
     
}
