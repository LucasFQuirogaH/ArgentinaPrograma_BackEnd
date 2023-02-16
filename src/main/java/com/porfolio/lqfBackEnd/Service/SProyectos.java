package com.porfolio.lqfBackEnd.Service;

import com.porfolio.lqfBackEnd.Entity.Proyectos;
import com.porfolio.lqfBackEnd.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyectos {

    @Autowired
    RProyectos rProyectos;

    public List<Proyectos> list() {
        return rProyectos.findAll();
    }

    public Optional<Proyectos> getOne(int id) {
        return rProyectos.findById(id);
    }

    public Optional<Proyectos> getByNombre(String nombre) {
        return rProyectos.findByNombre(nombre);
    }

    public void save(Proyectos proyectos) {
        rProyectos.save(proyectos);
    }

    public void delete(int id) {
        rProyectos.deleteById(id);
    }

    public boolean existsById(int id) {
        return rProyectos.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return rProyectos.existsByNombre(nombre);
    }
    
    // ---------------------------------  -------  ------------------------------------- //
    // ---------------------------------  Metodos  ------------------------------------- //
    // ---------------------------------  -------  ------------------------------------- //
    public Optional<Proyectos> getByFotoDescripcion(String fotoDescripcion) {
        return rProyectos.findByFotoDescripcion(fotoDescripcion);
    }

    public boolean existsByFotoDescripcion(String fotoDescripcion) {
        return rProyectos.existsByFotoDescripcion(fotoDescripcion);
    }
    // ---------------------------------  Metodos  -------------------------------------
    // ---------------------------------  Metodos  -------------------------------------
    public Optional<Proyectos> getByLink(String link) {
        return rProyectos.findByLink(link);
    }

    public boolean existsByLink(String link) {
        return rProyectos.existsByLink(link);
    }
    // ---------------------------------  Metodos  -------------------------------------
}
