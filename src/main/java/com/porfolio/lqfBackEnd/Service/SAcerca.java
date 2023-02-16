package com.porfolio.lqfBackEnd.Service;

import com.porfolio.lqfBackEnd.Entity.Acerca;
import com.porfolio.lqfBackEnd.Repository.RAcerca;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAcerca {

    @Autowired // Inyectar repositorio
    RAcerca rAcerca;

    // ------------------------- Metodos --------------------------
    public List<Acerca> list() {
        return rAcerca.findAll(); // Arma lista con todas las experiencias que encuentre
    }

    public Optional<Acerca> getOne(int id) {
        return rAcerca.findById(id);
    }

    public Optional<Acerca> getByDescripcionE(String descripcion) {
        return rAcerca.findByDescripcion(descripcion);
    }

    public void save(Acerca acercA) {
        rAcerca.save(acercA);
    }

    public void delete(int id) {
        rAcerca.deleteById(id);
    }

    public boolean existsById(int id) {
        return rAcerca.existsById(id);
    }

    public boolean existsByDescripcion(String descripcion) {
        return rAcerca.existsByDescripcion(descripcion);
    }

}
