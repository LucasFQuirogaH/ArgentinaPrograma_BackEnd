package com.porfolio.lqfBackEnd.Repository;

import com.porfolio.lqfBackEnd.Entity.Acerca;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RAcerca extends JpaRepository<Acerca, Integer> {
    Optional<Acerca>findByDescripcion(String descripcion);
    public boolean existsByDescripcion(String descripcion);
}
