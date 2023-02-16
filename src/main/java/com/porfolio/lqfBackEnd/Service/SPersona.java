package com.porfolio.lqfBackEnd.Service;

import com.porfolio.lqfBackEnd.Entity.Persona;
import com.porfolio.lqfBackEnd.Repository.RPersona;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPersona {

    @Autowired
    RPersona rPersona;

    // ---------------------------------  Generales  -------------------------------------
    public List<Persona> list() {
        return rPersona.findAll();
    }

    public void save(Persona persona) {
        rPersona.save(persona);
    }

    public void delete(int id) {
        rPersona.deleteById(id);
    }
    
    public Optional<Persona> getOne(int id) {
        return rPersona.findById(id);
    }

    public boolean existsById(int id) {
        return rPersona.existsById(id);
    }
    
    // ---------------------------------  Metodos  -------------------------------------
    public Optional<Persona> getByNombreCompleto(String nombreCompleto) {
        return rPersona.findByNombreCompleto(nombreCompleto);
    }

    public boolean existsByNombreCompleto(String nombreCompleto) {
        return rPersona.existsByNombreCompleto(nombreCompleto);
    }

    // ---------------------------------  Metodos  -------------------------------------
    public Optional<Persona> getByProfesion(String profesion) {
        return rPersona.findByProfesion(profesion);
    }

    public boolean existsByProfesion(String profesion) {
        return rPersona.existsByProfesion(profesion);
    }

    // ---------------------------------  Metodos  -------------------------------------
    public Optional<Persona> getByUbicacion(String ubicacion) {
        return rPersona.findByUbicacion(ubicacion);
    }

    public boolean existsByUbicacion(String ubicacion) {
        return rPersona.existsByUbicacion(ubicacion);
    }

    // ---------------------------------  Metodos  -------------------------------------
    public Optional<Persona> getByFotoPerfil(String fotoPerfil) {
        return rPersona.findByFotoPerfil(fotoPerfil);
    }

    public boolean existsByFotoPerfil(String fotoPerfil) {
        return rPersona.existsByFotoPerfil(fotoPerfil);
    }
    // ---------------------------------  Metodos  -------------------------------------
    public Optional<Persona> getByFotoPortada(String fotoPortada) {
        return rPersona.findByFotoPortada(fotoPortada);
    }

    public boolean existsByFotoPortada(String fotoPortada) {
        return rPersona.existsByFotoPortada(fotoPortada);
    }
    // ---------------------------------  Metodos  -------------------------------------

}
