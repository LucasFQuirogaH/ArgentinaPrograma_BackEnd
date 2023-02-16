package com.porfolio.lqfBackEnd.Repository;

import com.porfolio.lqfBackEnd.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RPersona extends JpaRepository<Persona, Integer> {

    //Aqui estan los metodos exclusivos que vas a ocupar en el service y que el service se
    //instancia en el controller. En el service se implementan estos metodos, aparte del id y metodos
    // mas genericos.
    // Todos los metodos de aqui estan relacionados solo con los atributos.
    
    
    public Optional<Persona> findByNombreCompleto(String nombreCompleto);
    public boolean existsByNombreCompleto(String nombreCompleto);

    public Optional<Persona> findByProfesion(String profesion);
    public boolean existsByProfesion(String profesion);
    
    public Optional<Persona> findByUbicacion(String ubicacion);
    public boolean existsByUbicacion(String ubicacion);
    
    public Optional<Persona> findByFotoPerfil(String fotoPerfil);
    public boolean existsByFotoPerfil(String fotoPerfil);
    
    public Optional<Persona> findByFotoPortada(String fotoPortada);
    public boolean existsByFotoPortada(String fotoPortada);
}
