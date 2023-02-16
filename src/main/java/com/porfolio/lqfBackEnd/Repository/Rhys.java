package com.porfolio.lqfBackEnd.Repository;

import com.porfolio.lqfBackEnd.Entity.hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rhys extends JpaRepository<hys, Integer>{
    //Mencionamos los metodos
    Optional<hys>findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
