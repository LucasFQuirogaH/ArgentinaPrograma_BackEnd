/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porfolio.lqfBackEnd.Repository;

import com.porfolio.lqfBackEnd.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos extends JpaRepository<Proyectos, Integer> {

    public Optional<Proyectos> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);

    public Optional<Proyectos> findByFotoDescripcion(String fotoDescripcion);
    public boolean existsByFotoDescripcion(String fotoDescripcion);
    
    public Optional<Proyectos> findByLink(String link);
    public boolean existsByLink(String link);
}
